package com.treeengineering.db.datastore

import com.treeengineering.db.entity.AccessTokenEntity

interface AccessTokenDataStore {
    suspend fun save(accessToken: AccessTokenEntity)
    suspend fun getAccessToken(): String
    suspend fun getAuthorizationHeader(): String
}
