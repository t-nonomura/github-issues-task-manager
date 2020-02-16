package com.treeengineering.di

import com.treeengineering.db.TMGIDatabaseFactory
import com.treeengineering.db.datastore.AccessTokenDataStore
import com.treeengineering.db.datastore.AccessTokenDataStoreImpl
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dbModule = module {
    single { TMGIDatabaseFactory.create(androidContext()) }
    single { AccessTokenDataStoreImpl(get()) as AccessTokenDataStore }
}
