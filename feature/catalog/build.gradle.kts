@file:Suppress("UnstableApiUsage")

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
}

android {
    namespace = "com.maxxxwk.catalog"
    compileSdk = Versions.COMPILE_SDK

    defaultConfig {
        minSdk = Versions.MIN_SDK
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_18
        targetCompatibility = JavaVersion.VERSION_18
    }
    kotlinOptions.jvmTarget = "18"
    buildFeatures.compose = true
    composeOptions.kotlinCompilerExtensionVersion = Versions.COMPOSE_KOTLIN_COMPILER_EXTENCION
}

dependencies {
    implementation(Libraries.LIFECYCLE_RUNTIME)
    implementation(Libraries.LIFECYCLE_VIEWMODEL_COMPOSE)
    implementation(Libraries.LIFECYCLE_RUNTIME_COMPOSE)

    implementation(platform(BillsOfMaterials.COMPOSE))
    implementation(Libraries.COMPOSE_UI)
    implementation(Libraries.COMPOSE_MATERIAL)
    implementation(Libraries.COMPOSE_UI_TOOLING_PREVIEW)
    debugImplementation(DebugLibraries.COMPOSE_UI_TOOLING)

    implementation(Libraries.DAGGER)
    kapt(KaptCompilers.DAGGER)

    implementation(Libraries.KOTLINX_COLLECTIONS_IMMUTABLE)

    implementation(Libraries.COIL)

    implementation(project(":core:android"))
    implementation(project(":core:kotlin"))
    implementation(project(":data:network"))
}