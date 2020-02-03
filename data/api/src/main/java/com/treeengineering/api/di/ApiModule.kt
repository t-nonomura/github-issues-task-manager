package com.treeengineering.api.di

import com.treeengineering.api.ApiClient
import org.koin.dsl.module

val apiModule = module {
    single { ApiClient.getService() }
}
