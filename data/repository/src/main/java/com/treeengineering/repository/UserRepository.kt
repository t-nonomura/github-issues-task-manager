package com.treeengineering.repository

import com.treeengineering.db.entity.UserEntity
import com.treeengineering.model.response.User

interface UserRepository {
    suspend fun getUser(): User

    suspend fun saveUser(userEntity: UserEntity)

    suspend fun getUserName(): String
}
