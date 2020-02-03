package com.treeengineering.githubissuestaskmanager

import android.app.Application
import com.treeengineering.api.di.apiModule
import com.treeengineering.githubissuestaskmanager.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.dsl.module

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            module { (listOf(appModule, apiModule)) }
        }
    }
}
