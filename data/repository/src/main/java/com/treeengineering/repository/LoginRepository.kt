package com.treeengineering.repository

import com.treeengineering.db.entity.AccessTokenEntity
import com.treeengineering.model.request.AccessTokenRequest
import com.treeengineering.model.response.AccessTokenResponse

interface LoginRepository {
    suspend fun accessToken(request: AccessTokenRequest): AccessTokenResponse

    suspend fun saveAccessToken(accessToken: AccessTokenEntity)

    suspend fun getAccessToken(): String
}
