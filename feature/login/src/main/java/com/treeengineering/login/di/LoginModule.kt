package com.treeengineering.login.di

import com.treeengineering.login.ui.*
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val loginModule = module {
    factory { LoginDispatcherImpl() as LoginDispatcher }
    factory { LoginActionCreatorImpl(get(), get()) as LoginActionCreator }
    viewModel { LoginStore(get()) }
}
