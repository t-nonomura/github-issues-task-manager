package com.treeengineering.githubissuestaskmanager.api

import com.treeengineering.githubissuestaskmanager.api.response.Repo
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    /**
     * 指定したユーザのリポジトリ一覧
     * @see https://developer.github.com/v3/repos/#list-user-repositories
     */
    @GET("users/{username*/repos")
    suspend fun getUsersRepositories(@Path("user") user: String): List<Repo>
}
