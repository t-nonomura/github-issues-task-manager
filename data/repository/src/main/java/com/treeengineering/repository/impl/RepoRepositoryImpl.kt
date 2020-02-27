package com.treeengineering.repository.impl

import com.treeengineering.api.ApiService
import com.treeengineering.db.datastore.UserDataStore
import com.treeengineering.model.response.Repo
import com.treeengineering.repository.RepoRepository

class RepoRepositoryImpl(
    private val api: ApiService,
    private val userDataStore: UserDataStore
) : RepoRepository {
    override suspend fun getRepoList(): List<Repo> {
        val userName = userDataStore.getUserName()
        return api.getUsersRepos(userName)
    }
}
