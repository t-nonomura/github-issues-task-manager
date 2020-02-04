package com.treeengineering.repository

interface LoginRepository {
    suspend fun loginGithubOAuth()
}
