package com.treeengineering.repository.di

import com.treeengineering.repository.LoginRepository
import com.treeengineering.repository.RepoRepository
import com.treeengineering.repository.impl.LoginRepositoryImpl
import com.treeengineering.repository.impl.RepoRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    factory { LoginRepositoryImpl(get(), get()) as LoginRepository }
    factory { RepoRepositoryImpl(get()) as RepoRepository }
}
