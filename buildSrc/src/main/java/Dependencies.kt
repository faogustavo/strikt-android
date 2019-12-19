
object Versions {
    val gradle = "3.5.2"
    val kotlin = "1.3.61"
    val bintrayRelease = "0.9.2"

    val androidx = "1.0.2"
    val junit = "4.12"
    val mockk = "1.9.3"

    // Configuration
    val strikt = "0.22.3"
    val minSdk = 15
    val targetSdk = 29
    val buildTools = "29.0.2"
    val versionCode = 1

    val instrumentedVersion = "1.1.1"
}

object Libs {
    val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlin}"
    val ktx = "androidx.core:core-ktx:${Versions.androidx}"
    val appCompat = "androidx.appcompat:appcompat:${Versions.androidx}"
    val striktCore = "io.strikt:strikt-core:${Versions.strikt}"
    val junit = "junit:junit:${Versions.junit}"
    val mockk = "io.mockk:mockk:${Versions.mockk}"

    val androidJunit = "androidx.test.ext:junit:${Versions.instrumentedVersion}"
    val androidRunner = "androidx.test:runner:${Versions.instrumentedVersion}"
}

object BuildDependencies {
    val gradle = "com.android.tools.build:gradle:${Versions.gradle}"
    val kotlin = "gradle-plugin"
    val release = "com.novoda:bintray-release:${Versions.bintrayRelease}"
}

object Distribution {
    object Android {
        val groupId = "io.strikt"
        val artifactId = "strikt-android"
        val version = "${Versions.strikt}-alpha02"
    }
}
