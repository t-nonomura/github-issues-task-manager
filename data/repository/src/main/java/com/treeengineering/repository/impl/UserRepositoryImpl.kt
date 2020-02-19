package com.treeengineering.repository.impl

import com.treeengineering.api.ApiService
import com.treeengineering.db.datastore.AccessTokenDataStore
import com.treeengineering.db.datastore.UserDataStore
import com.treeengineering.db.entity.UserEntity
import com.treeengineering.model.response.User
import com.treeengineering.repository.UserRepository

class UserRepositoryImpl(
    private val api: ApiService,
    private val accessTokenDataStore: AccessTokenDataStore,
    private val userDataStore: UserDataStore
) : UserRepository {
    override suspend fun getUser(): User {
        val authorization = accessTokenDataStore.getAuthorizationHeader()
        return api.getUser(authorization)
    }

    override suspend fun saveUser(userEntity: UserEntity) {
        userDataStore.save(userEntity)
    }

    override suspend fun getUserName(): String {
        return userDataStore.getUserName()
    }
}
