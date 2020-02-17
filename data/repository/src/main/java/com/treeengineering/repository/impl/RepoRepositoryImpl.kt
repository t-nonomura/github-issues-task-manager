package com.treeengineering.repository.impl

import com.treeengineering.api.ApiService
import com.treeengineering.model.response.Repo
import com.treeengineering.repository.RepoRepository

class RepoRepositoryImpl(private val api: ApiService) : RepoRepository {
    override suspend fun getRepoList(): List<Repo> {
        // TODO set user
        return api.getUsersRepos("")
    }
}