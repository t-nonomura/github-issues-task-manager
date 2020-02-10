package dependencies

object Dep {
    object GradlePlugin {
        val android = "com.android.tools.build:gradle:3.5.3"
        val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Kotlin.version}"
    }

    object AndroidX {
        val appCompat = "androidx.appcompat:appcompat:1.1.0"
        val coreKtx = "androidx.core:core-ktx:1.1.0"
        val constraint = "androidx.constraintlayout:constraintlayout:2.0.0-beta2"

        object Navigation {
            val version = "2.1.0"
            val navFragment = "androidx.navigation:navigation-fragment:$version"
            val navUi = "androidx.navigation:navigation-ui:$version"
            val navFragmentKtx = "androidx.navigation:navigation-fragment-ktx:$version"
            val navUiKtx = "androidx.navigation:navigation-ui-ktx:$version"
        }

        object Room {
            val version = "2.2.3"
            val roomRuntime = "androidx.room:room-runtime:$version"
            val roomCompiler = "androidx.room:room-compiler:$version"
            val roomKtx = "androidx.room:room-ktx:$version"
        }
    }

    object Arch {
        object Lifecycle {
            val version = "1.1.1"
            val runtime = "android.arch.lifecycle:runtime:$version"
            val extensions = "android.arch.lifecycle:extensions:$version"
            val reactivestreams = "android.arch.lifecycle:reactivestreams:$version"
        }
    }

    object ReactiveX {
        val rxJava = "io.reactivex.rxjava2:rxjava:2.1.6"
        val rxAndroid = "io.reactivex.rxjava2:rxandroid:2.0.1"
        val rxKotlin = "io.reactivex.rxjava2:rxkotlin:2.4.0"
    }

    object Kotlin {
        val version = "1.3.61"
        val stdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:$version"

        object Coroutines {
            val version = "1.3.1"
            val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
            val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$version"
        }
    }

    object Koin {
        val version = "2.0.1"
        val koinCore = "org.koin:koin-core:$version"
        val koinCoreExt = "org.koin:koin-core-ext:$version"
        val koinAndroidScope = "org.koin:koin-androidx-scope:$version"
        val koinAndroidViewModel = "org.koin:koin-androidx-viewmodel:$version"
        val koinAndroidExt = "org.koin:koin-androidx-ext:$version"
        val koinAndroidFragment = "org.koin:koin-androidx-fragment:$version"
        val koinTest = "org.koin:koin-test:$version"
    }

    object Google {
        val material = "com.google.android.material:material:1.0.0"
    }

    object Test {
        val junit = "junit:junit:4.12"
        val androidJunitKtx = "androidx.test.ext:junit-ktx:1.1.2-alpha02"
        val espressoCore = "androidx.test.espresso:espresso-core:3.3.0-alpha02"
    }

    object Square {
        val okHttp3 = "com.squareup.okhttp3:logging-interceptor:4.0.1"

        object Retrofit {
            val version = "2.6.1"
            val retrofit = "com.squareup.retrofit2:retrofit:$version"
            val retrofitConverterGson = "com.squareup.retrofit2:converter-gson:$version"
            val retrofitRxJava = "com.squareup.retrofit2:adapter-rxjava2:$version"
        }
    }
}
