@file:Suppress("UnstableApiUsage")

include(":data:local-preferences")


include(":data:network")


include(":core:android")


include(":core:kotlin")


pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "Test Task"
include(":app")
