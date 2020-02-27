package com.treeengineering.db.datastore

import com.treeengineering.db.entity.UserEntity

interface UserDataStore {
    suspend fun save(userEntity: UserEntity)
    suspend fun getUserName(): String
}
