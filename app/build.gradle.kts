@file:Suppress("UnstableApiUsage")

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("org.jetbrains.kotlin.plugin.serialization") version "1.8.20"
}

android {
    namespace = "com.maxxxwk.testtask"
    compileSdk = Versions.COMPILE_SDK

    defaultConfig {
        applicationId = "com.maxxxwk.testtask"
        minSdk = Versions.MIN_SDK
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        vectorDrawables.useSupportLibrary = true

        buildConfigField("String", "BASE_URL", "\"https://cr-test-ribu2uaqea-ey.a.run.app/\"")
        buildConfigField("String", "APP_NAME", "\"cuton\"")
        buildConfigField("int", "BUILD_NUMBER", "36")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions.jvmTarget = "1.8"
    buildFeatures.compose = true
    composeOptions.kotlinCompilerExtensionVersion = Versions.COMPOSE_KOTLIN_COMPILER_EXTENCION
    packagingOptions.resources.excludes.add("/META-INF/{AL2.0,LGPL2.1}")
}

dependencies {
    implementation(Libraries.LIFECYCLE_RUNTIME)
    implementation(Libraries.LIFECYCLE_VIEWMODEL_COMPOSE)

    implementation(platform(BillsOfMaterials.COMPOSE))
    implementation(Libraries.COMPOSE_UI)
    implementation(Libraries.COMPOSE_MATERIAL)
    implementation(Libraries.COMPOSE_UI_TOOLING_PREVIEW)
    debugImplementation(DebugLibraries.COMPOSE_UI_TOOLING)
    implementation(Libraries.COMPOSE_NAVIGATION)
    implementation(Libraries.ACTIVITY_COMPOSE)

    implementation(Libraries.COIL)

    implementation(Libraries.DAGGER)
    kapt(KaptCompilers.DAGGER)

    implementation(Libraries.RETROFIT)

    implementation(Libraries.KOTLINX_COLLECTIONS_IMMUTABLE)

    implementation(project(":core:kotlin"))
    implementation(project(":core:android"))
    implementation(project(":data:network"))
    implementation(project(":data:local-preferences"))
}