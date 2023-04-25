object Versions {
    const val COMPILE_SDK = 33
    const val MIN_SDK = 21

    const val COMPOSE_KOTLIN_COMPILER_EXTENCION = "1.4.6"

    const val LIFECYCLE = "2.6.1"
    const val DAGGER = "2.45"
}

object BillsOfMaterials {
    const val COMPOSE = "androidx.compose:compose-bom:2023.04.01"
    const val OKHTTP = "com.squareup.okhttp3:okhttp-bom:4.10.0"
}

object Libraries {
    const val LIFECYCLE_RUNTIME = "androidx.lifecycle:lifecycle-runtime:${Versions.LIFECYCLE}"
    const val LIFECYCLE_VIEWMODEL_COMPOSE = "androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.LIFECYCLE}"

    const val COMPOSE_UI = "androidx.compose.ui:ui"
    const val COMPOSE_UI_TOOLING_PREVIEW = "androidx.compose.ui:ui-tooling-preview"
    const val COMPOSE_MATERIAL = "androidx.compose.material:material"
    const val COMPOSE_NAVIGATION = "androidx.navigation:navigation-compose:2.5.3"
    const val ACTIVITY_COMPOSE = "androidx.activity:activity-compose:1.7.1"

    const val COIL = "io.coil-kt:coil-compose:2.3.0"

    const val DAGGER = "com.google.dagger:dagger:${Versions.DAGGER}"

    const val KOTLINX_COLLECTIONS_IMMUTABLE = "org.jetbrains.kotlinx:kotlinx-collections-immutable:0.3.5"
    const val KOTLINX_SERIALIZATION_JSON = "org.jetbrains.kotlinx:kotlinx-serialization-json:1.5.0"

    const val OKHTTP = "com.squareup.okhttp3:okhttp"
    const val OKHTTP_LOGGING_INTERCEPTOR = "com.squareup.okhttp3:logging-interceptor"

    const val RETROFIT = "com.squareup.retrofit2:retrofit:2.9.0"
    const val RETROFIT_KOTLINX_SERIALIZATION_CONVERTER = "com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:1.0.0"

    const val COROUTINES_CORE = "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.0-RC"

    const val DATASTORE = "androidx.datastore:datastore-preferences:1.0.0"
}

object DebugLibraries {
    const val COMPOSE_UI_TOOLING = "androidx.compose.ui:ui-tooling"
}

object KaptCompilers {
    const val DAGGER = "com.google.dagger:dagger-compiler:${Versions.DAGGER}"
}