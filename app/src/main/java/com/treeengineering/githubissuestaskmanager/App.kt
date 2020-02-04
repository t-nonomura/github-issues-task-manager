package com.treeengineering.githubissuestaskmanager

import android.app.Application
import com.treeengineering.api.di.apiModule
import com.treeengineering.core.di.coreModule
import com.treeengineering.githubissuestaskmanager.di.appModule
import com.treeengineering.login.di.loginModule
import com.treeengineering.repository.di.repositoryModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.dsl.module

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        setupDI()
    }

    private fun setupDI() {
        startKoin {
            androidContext(this@App)
            module { (listOf(
                appModule,
                coreModule,
                apiModule,
                repositoryModule,
                loginModule)) }
        }
    }
}
