plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.ksp)
    id("kotlin-parcelize")
}

android {
    namespace = "uz.toshmatov.wedrive"
    compileSdk = 35

    defaultConfig {
        applicationId = "uz.toshmatov.wedrive"
        minSdk = 21
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
        buildConfig = true
    }
}

dependencies {
    // androidx lifecycle
    implementation(libs.androidx.lifecycle.viewmodel.compose)
    implementation(libs.androidx.lifecycle.runtime.compose)
    implementation(libs.androidx.lifecycle.runtime.ktx)

    // androidx core-ktx
    implementation(libs.androidx.core.ktx)

    // androidx appcompat
    implementation(libs.androidx.appcompat)

    // compose
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.activity.compose)
    implementation(libs.bundles.compose)

    // test
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.junit)
    testImplementation(libs.junit)

    // debug test
    debugImplementation(libs.bundles.compose.debug)

    // coil
    implementation(libs.bundles.coil)

    // timber
    implementation(libs.timber)

    // kotlin serialization json and kotlinx datetime
    implementation(libs.kotlinx.serialization.json)
    api(libs.kotlinx.collections.immutable)
    implementation(libs.kotlinx.datetime)

    // kotlin coroutines
    implementation(libs.bundles.coroutines)

    // android dataStore
    implementation(libs.bundles.dataStore)

    // koin compose
    implementation(libs.bundles.koin.compose)

    // lottie animation
    implementation(libs.lottie.compose)

    // ktor client
    implementation(libs.bundles.ktor)

    // voyager navigation
    implementation(libs.bundles.voyager)

    // chucker
    debugImplementation(libs.chucker.debug)
    releaseImplementation(libs.chucker.release)

    // splash screen
    implementation(libs.androidx.core.splash)

    // room database
    implementation(libs.bundles.room)
    ksp(libs.androidx.room.compiler)

    // gson
    implementation(libs.gson)

    // lingver
    implementation(libs.lingver)

    // google-accompanist
    implementation(libs.google.accompanist)

    // compose paging
    implementation(libs.androidx.paging.runtime)
    implementation(libs.androidx.compose.paging)
}