package com.treeengineering.repolist.di

import com.treeengineering.repolist.ui.RepoListActionCreator
import com.treeengineering.repolist.ui.RepoListActionCreatorImpl
import com.treeengineering.repolist.ui.RepoListStore
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val repoListModule = module {
    factory { RepoListActionCreatorImpl(get()) as RepoListActionCreator }
    viewModel { RepoListStore(get()) }
}
