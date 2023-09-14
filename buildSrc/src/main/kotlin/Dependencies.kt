object Versions {
    const val COMPILE_SDK = 34
    const val MIN_SDK = 21

    const val COMPOSE_KOTLIN_COMPILER_EXTENCION = "1.5.3"

    const val LIFECYCLE = "2.6.2"
    const val KOIN = "3.5.0"
}

object BillsOfMaterials {
    const val COMPOSE = "androidx.compose:compose-bom:2023.09.00"
    const val OKHTTP = "com.squareup.okhttp3:okhttp-bom:4.10.0"
}

object Libraries {
    const val LIFECYCLE_RUNTIME = "androidx.lifecycle:lifecycle-runtime:${Versions.LIFECYCLE}"
    const val LIFECYCLE_VIEWMODEL_COMPOSE = "androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.LIFECYCLE}"
    const val LIFECYCLE_RUNTIME_COMPOSE = "androidx.lifecycle:lifecycle-runtime-compose:${Versions.LIFECYCLE}"

    const val COMPOSE_UI = "androidx.compose.ui:ui"
    const val COMPOSE_UI_TOOLING_PREVIEW = "androidx.compose.ui:ui-tooling-preview"
    const val COMPOSE_MATERIAL = "androidx.compose.material:material"
    const val COMPOSE_NAVIGATION = "androidx.navigation:navigation-compose:2.7.2"
    const val ACTIVITY_COMPOSE = "androidx.activity:activity-compose:1.7.2"

    const val COIL = "io.coil-kt:coil-compose:2.4.0"

    const val KOTLINX_COLLECTIONS_IMMUTABLE = "org.jetbrains.kotlinx:kotlinx-collections-immutable:0.3.5"
    const val KOTLINX_SERIALIZATION_JSON = "org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.0"

    const val OKHTTP = "com.squareup.okhttp3:okhttp"
    const val OKHTTP_LOGGING_INTERCEPTOR = "com.squareup.okhttp3:logging-interceptor"

    const val RETROFIT = "com.squareup.retrofit2:retrofit:2.9.0"
    const val RETROFIT_KOTLINX_SERIALIZATION_CONVERTER = "com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:1.0.0"

    const val COROUTINES_CORE = "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3"

    const val DATASTORE = "androidx.datastore:datastore-preferences:1.0.0"

    const val KOIN_CORE = "io.insert-koin:koin-core:${Versions.KOIN}"
    const val KOIN_ANDROID = "io.insert-koin:koin-android:${Versions.KOIN}"
    const val KOIN_COMPOSE = "io.insert-koin:koin-androidx-compose:${Versions.KOIN}"

    const val COMPOSE_STATE_EVENTS = "com.github.leonard-palm:compose-state-events:2.0.3"
}

object DebugLibraries {
    const val COMPOSE_UI_TOOLING = "androidx.compose.ui:ui-tooling"
}
