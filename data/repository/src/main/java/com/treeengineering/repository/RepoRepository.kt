package com.treeengineering.repository

import com.treeengineering.model.response.Repo

interface RepoRepository {
    suspend fun getRepoList(userName: String): List<Repo>
}
