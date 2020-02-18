package com.treeengineering.repository.impl

import com.treeengineering.api.AuthService
import com.treeengineering.db.datastore.AccessTokenDataStore
import com.treeengineering.db.entity.AccessTokenEntity
import com.treeengineering.model.request.AccessTokenRequest
import com.treeengineering.model.response.AccessTokenResponse
import com.treeengineering.repository.LoginRepository

class LoginRepositoryImpl(
    private val api: AuthService,
    private val accessTokenDataStore: AccessTokenDataStore
) : LoginRepository {
    override suspend fun requestAccessToken(request: AccessTokenRequest): AccessTokenResponse {
        return api.accessToken(request)
    }

    override suspend fun saveAccessToken(accessToken: AccessTokenEntity) {
        accessTokenDataStore.save(accessToken)
    }

    override suspend fun getAccessToken(): String {
        return accessTokenDataStore.getAccessToken()
    }
}
