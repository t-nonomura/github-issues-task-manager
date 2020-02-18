package com.treeengineering.api

import com.treeengineering.model.request.AccessTokenRequest
import com.treeengineering.model.response.AccessTokenResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {
    /**
     * OAuth認証
     * @see https://developer.github.com/apps/building-oauth-apps/authorizing-oauth-apps/
     */
    @POST("login/oauth/access_token")
    suspend fun accessToken(@Body param: AccessTokenRequest): AccessTokenResponse
}
