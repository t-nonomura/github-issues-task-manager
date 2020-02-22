package com.treeengineering.repolist.ui

import com.treeengineering.repository.RepoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class RepoListActionCreatorImpl(
    private val repoRepository: RepoRepository
) : RepoListActionCreator {
    override fun getRepoList() {
        GlobalScope.launch(Dispatchers.Main) {
            repoRepository.getRepoList()
        }
    }
}
