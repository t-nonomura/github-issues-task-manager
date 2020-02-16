package com.treeengineering.api.di

import com.treeengineering.api.ApiClient
import com.treeengineering.api.AuthClient
import org.koin.dsl.module

val apiModule = module {
    single { ApiClient.getService() }
    single { AuthClient.getService() }
}
