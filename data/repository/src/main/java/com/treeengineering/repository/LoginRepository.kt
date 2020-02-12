package com.treeengineering.repository

import com.treeengineering.model.request.AccessTokenRequest
import com.treeengineering.model.response.AccessTokenResponse

interface LoginRepository {
    suspend fun accessToken(param: AccessTokenRequest): AccessTokenResponse
}
