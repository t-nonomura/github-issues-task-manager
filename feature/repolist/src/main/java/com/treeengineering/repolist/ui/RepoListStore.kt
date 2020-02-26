package com.treeengineering.repolist.ui

import com.treeengineering.core.dispatcher.Dispatcher
import com.treeengineering.core.ext.toLiveData
import com.treeengineering.core.store.Store
import kotlinx.coroutines.channels.map

class RepoListStore(dispatcher: Dispatcher) : Store() {
    val repoList = dispatcher
        .subscribe<RepoListAction.RepoListGetAction>()
        .map { it.repoList }
        .toLiveData(this)

    val progress = dispatcher
        .subscribe<RepoListAction.ProgressAction>()
        .map { it.visible }
        .toLiveData(this)
}
