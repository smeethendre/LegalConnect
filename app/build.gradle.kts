plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.example.legalapp"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.legalapp"
        minSdk = 24
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
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.firebase.firestore.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    //retrofit
    implementation(libs.retrofit)

    //gson converter
    implementation (libs.converter.gson)

    //okhttp
    implementation(libs.okhttp)
    implementation (libs.logging.interceptor)

    implementation ("androidx.lifecycle:lifecycle-viewmodel:2.6.0")
    implementation ("androidx.lifecycle:lifecycle-livedata:2.6.0")
    implementation ("androidx.lifecycle:lifecycle-extensions:2.2.0")
    implementation ("com.github.bumptech.glide:glide:4.16.0")

    implementation ("com.tbuonomo:dotsindicator:5.1.0")

    //firebase-firestorq
    implementation ("com.google.firebase:firebase-firestore:25.1.2")
    implementation ("com.google.firebase:firebase-auth:25.1.2")
}