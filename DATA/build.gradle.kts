plugins {
    alias(libs.plugins.android.library)
}

android {
    namespace = "com.xio.leo.data"
    compileSdk = 37

    defaultConfig {
        minSdk = 29
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}
