package com.treeengineering.repository.impl

import com.treeengineering.api.AuthService
import com.treeengineering.model.request.AccessTokenRequest
import com.treeengineering.model.response.AccessTokenResponse
import com.treeengineering.repository.LoginRepository

class LoginRepositoryImpl(
    private val api: AuthService
) : LoginRepository {
    override suspend fun accessToken(param: com.treeengineering.model.request.AccessTokenRequest): com.treeengineering.model.response.AccessTokenResponse {
        return api.accessToken(param)
    }
}
