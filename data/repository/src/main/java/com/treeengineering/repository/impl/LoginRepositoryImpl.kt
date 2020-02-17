package com.treeengineering.repository.impl

import com.treeengineering.api.AuthService
import com.treeengineering.db.datastore.AccessTokenDataStore
import com.treeengineering.db.entity.AccessTokenEntity
import com.treeengineering.model.request.AccessTokenRequest
import com.treeengineering.model.response.AccessTokenResponse
import com.treeengineering.repository.LoginRepository

class LoginRepositoryImpl(
    private val api: AuthService,
    private val localDataStore: AccessTokenDataStore
) : LoginRepository {
    override suspend fun accessToken(request: AccessTokenRequest): AccessTokenResponse {
        return api.accessToken(request)
    }

    override suspend fun saveAccessToken(accessToken: AccessTokenEntity) {
        localDataStore.save(accessToken)
    }

    override suspend fun getAccessToken(): String {
        return localDataStore.getAccessToken()
    }
}
