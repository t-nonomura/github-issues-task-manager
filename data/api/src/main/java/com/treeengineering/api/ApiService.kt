package com.treeengineering.api

import com.treeengineering.api.request.LoginRequest
import com.treeengineering.api.response.LoginResponse
import com.treeengineering.api.response.Repo
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {
    /**
     * OAuth認証
     * @see https://developer.github.com/apps/building-oauth-apps/authorizing-oauth-apps/
     */
    @POST("login/oauth/access_token")
    suspend fun loginGithubOAuth(@Body param: LoginRequest) : LoginResponse

    /**
     * 指定したユーザのリポジトリ一覧
     * @see https://developer.github.com/v3/repos/#list-user-repositories
     */
    @GET("users/{username}/repos")
    suspend fun getUsersRepositories(@Path("user") user: String): List<Repo>
}
