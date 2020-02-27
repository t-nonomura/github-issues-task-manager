package com.treeengineering.api

import com.treeengineering.model.response.Repo
import com.treeengineering.model.response.User
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface ApiService {
    /**
     * 指定したユーザのリポジトリ一覧
     * @see https://developer.github.com/v3/repos/#list-user-repositories
     */
    @GET("users/{user}/repos")
    suspend fun getUsersRepos(@Path("user") user: String): List<Repo>

    /**
     * 認証済みのユーザ情報
     */
    @GET("user")
    suspend fun getUser(@Header("Authorization") authorization: String): User
}
