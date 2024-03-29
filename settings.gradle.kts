pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
//        maven { url "https://kotlin.bintray.com/kotlinx" }
        maven { url = uri( "https://kotlin.bintray.com/kotlinx") }


    }
    resolutionStrategy {
        eachPlugin {
            if (requested.id.id == "kotlin-multiplatform") {
                useModule("org.jetbrains.kotlin:kotlin-gradle-plugin:${requested.version}")
            }
            if (requested.id.id == "kotlinx-serialization") {
                useModule("org.jetbrains.kotlin:kotlin-serialization:${requested.version}")
            }
        }
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()

    }
}

rootProject.name = "PotterMVVM"
include(":app")
