plugins {
    /**
     * Здесь объявляются Gradle плагины, которые используются в этом Gradle модуле.
     * Gradle плагины нужны для того, чтобы выполнять какие-то задачи (таски) с помощью Gradle.
     * Например, плагин для сборки андроид приложения (AGP) подключается через id
     * 'com.android.application'. В нашем случае этот id спрятан в toml файл по пути
     * 'libs.plugins.android.application'
     * Этот плагин знает как собрать apk файл из файлов проекта.
     * Например, Gradle таска assemble объявлена именно в нём и когда мы вызываем команду
     * `./gradlew :app:assembleDebug', то этот плагин компилирует модуль app и все нужные ему
     * зависимости, а затем формирует apk файл.
     */
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.compose.compiler)
}

android {
    namespace = "khv.casper.weathernew"
    compileSdk = 35

    defaultConfig {
        applicationId = "khv.casper.weathernew"
        minSdk = 21
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        debug {
            isMinifyEnabled = false
            isDebuggable = true
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.material3)
    implementation(libs.androidx.ui.tooling.preview)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
}