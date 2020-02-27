package com.treeengineering.login.di

import com.treeengineering.login.ui.LoginActionCreator
import com.treeengineering.login.ui.LoginActionCreatorImpl
import com.treeengineering.login.ui.LoginStore
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val loginModule = module {
    factory { LoginActionCreatorImpl(get(), get(), get(), get()) as LoginActionCreator }
    viewModel { LoginStore(get()) }
}
