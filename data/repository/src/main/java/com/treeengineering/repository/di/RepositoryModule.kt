package com.treeengineering.repository.di

import com.treeengineering.repository.LoginRepository
import com.treeengineering.repository.impl.LoginRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    factory { LoginRepositoryImpl() as LoginRepository }
}
