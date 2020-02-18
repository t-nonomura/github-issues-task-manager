package com.treeengineering.repolist.ui

import com.treeengineering.repository.RepoRepository
import com.treeengineering.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class RepoListActionCreatorImpl(
    private val userRepository: UserRepository,
    private val repoRepository: RepoRepository
) : RepoListActionCreator {
    override fun getRepoList() {
        GlobalScope.launch(Dispatchers.Main) {
            val userName = userRepository.getUserName()
            repoRepository.getRepoList(userName)
        }
    }
}
