package com.treeengineering.core.di

import com.treeengineering.core.dispatcher.Dispatcher
import com.treeengineering.core.dispatcher.impl.DispatcherImpl
import org.koin.dsl.module

val coreModule = module {
    single { DispatcherImpl() as Dispatcher}
}
