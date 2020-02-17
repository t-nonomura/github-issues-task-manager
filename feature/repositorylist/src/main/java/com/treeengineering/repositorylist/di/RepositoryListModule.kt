package com.treeengineering.repositorylist.di

import com.treeengineering.repositorylist.ui.RepositoryListActionCreator
import com.treeengineering.repositorylist.ui.RepositoryListActionCreatorImpl
import com.treeengineering.repositorylist.ui.RepositoryListStore
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val repositoryListModule = module {
    factory { RepositoryListActionCreatorImpl() as RepositoryListActionCreator }
    viewModel { RepositoryListStore() }
}
