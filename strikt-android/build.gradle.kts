import com.novoda.gradle.release.PublishExtension

plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("android.extensions")
    id("jacoco")
    id("com.novoda.bintray-release")
}

jacoco {
    toolVersion = "0.8.5"
}

android {
    compileSdkVersion(Versions.targetSdk)
    buildToolsVersion(Versions.buildTools)

    sourceSets {
        getByName("main").java.srcDirs("src/main/kotlin/")
        getByName("test").java.srcDirs("src/test/kotlin/")
        getByName("androidTest").java.srcDirs("src/androidTest/kotlin/")
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    defaultConfig {
        minSdkVersion(Versions.minSdk)
        targetSdkVersion(Versions.targetSdk)
        versionCode = Versions.versionCode
        versionName = Versions.strikt

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
        getByName("debug") {
            isMinifyEnabled = false
            isDebuggable = true
            isTestCoverageEnabled = true
        }
    }

}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    implementation(Libs.kotlin)

    implementation(Libs.appCompat)
    implementation(Libs.ktx)
    implementation(Libs.striktCore)

    testImplementation(Libs.junit)
    testImplementation(Libs.mockk)
    testImplementation(Libs.striktCore)

    androidTestImplementation(Libs.androidRunner)
    androidTestImplementation(Libs.androidJunit)
    androidTestImplementation(Libs.striktCore)
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

configure<PublishExtension> {
    userOrg = "faogustavo"
    groupId = Distribution.Android.groupId
    artifactId = Distribution.Android.artifactId
    publishVersion = Distribution.Android.version
    desc = "Strikt extensions to validate android classes"
    website = "https://github.com/faogustavo/strikt-android"
    bintrayUser = System.getenv("BINTRAY_USER")
    bintrayKey = System.getenv("BINTRAY_KEY")
    dryRun = false
}

project.afterEvaluate {
    task<JacocoReport>("codeCoverageReport") {
        group = "reporting"

        val fileFilter = listOf(
            "**/R.class",
            "**/R$*.class",
            "**/BuildConfig.*",
            "**/Manifest*.*",
            "**/*Test*.*",
            "android/**/*.*",
            "**/*\$[0-9].*"
        )

        val coverageSourceDirs = listOf(
            "${project.projectDir}/src/main/java",
            "${project.projectDir}/src/main/kotlin"
        )

        val javaTree = fileTree("$buildDir/intermediates/classes/debug") {
            fileFilter.forEach(::exclude)
        }
        val kotlinTree = fileTree("$buildDir/tmp/kotlin-classes/debug") {
            fileFilter.forEach(::exclude)
        }

        val execData = fileTree(buildDir) {
            include("jacoco/*.exec")
        }

        sourceDirectories.setFrom(files(coverageSourceDirs))
        additionalSourceDirs.setFrom(files(coverageSourceDirs))
        classDirectories.setFrom(files(javaTree, kotlinTree))
        executionData.setFrom(execData)

        reports {
            html.isEnabled = true
            xml.isEnabled = true
        }

        val testTask = tasks.findByName("testDebugUnitTest")
        dependsOn(testTask)
    }
}
