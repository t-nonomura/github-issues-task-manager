package com.treeengineering.di

import com.treeengineering.db.TMGIDatabaseFactory
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dbModule = module {
    single {
        TMGIDatabaseFactory.create(androidContext())
    }
}
