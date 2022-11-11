plugins {
    id(Plugins.androidApplication)
    id(Plugins.kotlinAndroid)
    id(Plugins.kotlinKapt)
}

android {
    compileSdk = Configs.compileSdkVersion

    defaultConfig {
        applicationId = Configs.applicationId
        minSdk = Configs.minSdkVersion
        targetSdk = Configs.targetSdkVersion
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName<com.android.build.gradle.internal.dsl.BuildType>("release") {
            isMinifyEnabled = false
            setProguardFiles(
                    mutableListOf(
                            getDefaultProguardFile("proguard-android.txt"),
                            "proguard-rules.pro"
                    )
            )
        }
    }

    dataBinding.isEnabled = true
    buildFeatures.compose = true
    composeOptions {
        kotlinCompilerExtensionVersion = "1.3.2"
    }
}

dependencies {
    api(project(Components.ratingBar))
    implementation(project(Components.dialogs))
    implementation(project(Components.imageSlider))
    implementation(project(Components.phoneNumber))
    implementation(project(Components.toolbar))
    implementation(project(Components.suggestionInputView))
    implementation(project(Components.cardInputView))
    implementation(project(Components.quantityPickerView))
    implementation(project(Components.timelineView))
    implementation(project(Components.fitOptionMessageView))

    implementation(Dependencies.appCompat)
    implementation(Dependencies.coreKtx)
    implementation(Dependencies.material)
    implementation(Dependencies.constraintLayout)
    implementation(Dependencies.glide)
    implementation(Dependencies.composeActivity)
    implementation(Dependencies.composeUi)
}
