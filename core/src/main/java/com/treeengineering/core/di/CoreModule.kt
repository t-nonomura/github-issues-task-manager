package com.treeengineering.core.di

import com.treeengineering.core.dispatcher.Dispatcher
import com.treeengineering.core.ext.ManifestUtil
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val coreModule = module {
    single { ManifestUtil(androidContext()) }
    single { Dispatcher() }
}
