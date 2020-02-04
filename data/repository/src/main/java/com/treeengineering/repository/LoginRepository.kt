package com.treeengineering.repository

import com.treeengineering.api.request.LoginRequest

interface LoginRepository {
    suspend fun loginGithubOAuth(param: LoginRequest)
}
