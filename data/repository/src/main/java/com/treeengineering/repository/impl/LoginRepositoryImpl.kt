package com.treeengineering.repository.impl

import com.treeengineering.api.ApiService
import com.treeengineering.api.request.LoginRequest
import com.treeengineering.repository.LoginRepository

class LoginRepositoryImpl(
    private val api: ApiService
) : LoginRepository {
    override suspend fun loginGithubOAuth(param: LoginRequest) {
        val response = api.loginGithubOAuth(param)
    }
}
