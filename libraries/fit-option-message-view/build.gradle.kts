plugins {
    id(Plugins.androidLibrary)
    id(Plugins.kotlinAndroid)
       
}

group = Configs.group
version = ComponentVersions.fitOptionMessageView

android {
    compileSdkVersion(Configs.compileSdkVersion)

    defaultConfig {
        minSdkVersion(Configs.minSdkVersion)
        targetSdkVersion(Configs.targetSdkVersion)
        vectorDrawables.useSupportLibrary = true

        consumerProguardFiles("consumer-rules.pro")
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

}

dependencies {
     
    implementation(Dependencies.appCompat)
    implementation(Dependencies.coreKtx)
}
