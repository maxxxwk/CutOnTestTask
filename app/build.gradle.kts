@file:Suppress("UnstableApiUsage")

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("org.jetbrains.kotlin.plugin.serialization") version "1.9.10"
}

android {
    namespace = "com.maxxxwk.testtask"
    compileSdk = Versions.COMPILE_SDK

    defaultConfig {
        applicationId = "com.maxxxwk.testtask"
        minSdk = Versions.MIN_SDK
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        vectorDrawables.useSupportLibrary = true

        buildConfigField("String", "BASE_URL", "\"https://cr-test-ribu2uaqea-ey.a.run.app/\"")
        buildConfigField("String", "APP_NAME", "\"cuton\"")
        buildConfigField("int", "BUILD_NUMBER", "36")
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            isShrinkResources = true
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
    buildFeatures {
        compose = true
        buildConfig = true
    }
    composeOptions.kotlinCompilerExtensionVersion = Versions.COMPOSE_KOTLIN_COMPILER_EXTENCION
    packagingOptions.resources.excludes.add("/META-INF/{AL2.0,LGPL2.1}")
}

dependencies {
    implementation(platform(BillsOfMaterials.COMPOSE))
    implementation(Libraries.COMPOSE_UI)
    implementation(Libraries.COMPOSE_MATERIAL)
    implementation(Libraries.COMPOSE_UI_TOOLING_PREVIEW)
    debugImplementation(DebugLibraries.COMPOSE_UI_TOOLING)
    implementation(Libraries.COMPOSE_NAVIGATION)
    implementation(Libraries.ACTIVITY_COMPOSE)

    implementation(Libraries.KOIN_CORE)
    implementation(Libraries.KOIN_ANDROID)
    implementation(Libraries.KOIN_COMPOSE)

    implementation(project(":core:kotlin"))

    implementation(project(":data:network"))
    implementation(project(":data:local-preferences"))

    implementation(project(":feature:init"))
    implementation(project(":feature:auth"))
    implementation(project(":feature:logout"))
    implementation(project(":feature:home"))
    implementation(project(":feature:catalog"))
}