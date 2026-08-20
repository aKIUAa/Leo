plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.xio.leo"
    compileSdk = 37

    defaultConfig {
        applicationId = "com.xio.leo"
        minSdk = 29
        targetSdk = 36
        versionCode = 1
        versionName = "0.1"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    buildTypes {
        release {
            isMinifyEnabled = false
        }
    }
}
