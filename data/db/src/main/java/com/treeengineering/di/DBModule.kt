package com.treeengineering.di

import com.treeengineering.db.TMGIDatabaseFactory
import com.treeengineering.db.datastore.AccessTokenDataStore
import com.treeengineering.db.datastore.AccessTokenDataStoreImpl
import com.treeengineering.db.datastore.UserDataStore
import com.treeengineering.db.datastore.UserDataStoreImpl
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dbModule = module {
    single { TMGIDatabaseFactory.create(androidContext()) }
    single { AccessTokenDataStoreImpl(get()) as AccessTokenDataStore }
    single { UserDataStoreImpl(get()) as UserDataStore }
}
