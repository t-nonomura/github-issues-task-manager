package com.treeengineering.repolist.ui

import android.view.View
import com.treeengineering.core.dispatcher.Dispatcher
import com.treeengineering.repository.RepoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class RepoListActionCreatorImpl(
    private val dispatcher: Dispatcher,
    private val repoRepository: RepoRepository
) : RepoListActionCreator {
    override fun getRepoList() {
        GlobalScope.launch(Dispatchers.Main) {
            val repoList = repoRepository.getRepoList()
            dispatcher.dispatch(RepoListAction.RepoListGetAction(repoList))
        }
    }
}
