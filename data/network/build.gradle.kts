plugins {
    id("java-library")
    id("org.jetbrains.kotlin.jvm")
    id("kotlin-kapt")
    id("org.jetbrains.kotlin.plugin.serialization") version "1.9.10"
}

java {
    sourceCompatibility = JavaVersion.VERSION_18
    targetCompatibility = JavaVersion.VERSION_18
}
dependencies {
    implementation(Libraries.DAGGER)
    kapt(KaptCompilers.DAGGER)

    implementation(Libraries.KOTLINX_SERIALIZATION_JSON)

    implementation(platform(BillsOfMaterials.OKHTTP))
    implementation(Libraries.OKHTTP)
    implementation(Libraries.OKHTTP_LOGGING_INTERCEPTOR)

    implementation(Libraries.RETROFIT)
    implementation(Libraries.RETROFIT_KOTLINX_SERIALIZATION_CONVERTER)

    implementation(Libraries.COROUTINES_CORE)

    implementation(project(":core:kotlin"))
}