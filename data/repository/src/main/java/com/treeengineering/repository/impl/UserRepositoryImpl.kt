package com.treeengineering.repository.impl

import com.treeengineering.api.ApiService
import com.treeengineering.db.datastore.AccessTokenDataStore
import com.treeengineering.model.response.User
import com.treeengineering.repository.UserRepository

class UserRepositoryImpl(
    private val api: ApiService,
    private val accessTokenDataStore: AccessTokenDataStore
) : UserRepository {
    override suspend fun getUser(): User {
        val accessToken = accessTokenDataStore.getAccessToken()
        return api.getUser(accessToken)
    }
}
