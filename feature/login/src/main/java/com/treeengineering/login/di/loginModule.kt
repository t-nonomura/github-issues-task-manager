package com.treeengineering.login.di

import com.treeengineering.login.ui.actioncreator.LoginActionCreator
import com.treeengineering.login.ui.actioncreator.impl.LoginActionCreatorImpl
import com.treeengineering.login.ui.store.LoginStore
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val loginModule = module {
    factory { LoginActionCreatorImpl() as LoginActionCreator }
    viewModel { LoginStore() }
}
