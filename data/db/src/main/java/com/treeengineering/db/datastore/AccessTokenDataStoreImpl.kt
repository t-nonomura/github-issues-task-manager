package com.treeengineering.db.datastore

import com.treeengineering.db.TMGIDatabase
import com.treeengineering.db.entity.AccessTokenEntity

class AccessTokenDataStoreImpl(db: TMGIDatabase) : AccessTokenDataStore {
    private val dao = db.accessTokenDao()
    override suspend fun save(accessToken: AccessTokenEntity) {
        dao.save(accessToken)
    }

    override suspend fun getAccessToken(): String {
        return dao.getAccessToken() ?: ""
    }
}
