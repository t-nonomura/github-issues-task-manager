package com.treeengineering.db.datastore

import com.treeengineering.db.TMGIDatabase
import com.treeengineering.db.entity.AccessTokenEntity

class AccessTokenDataStoreImpl(private val db: TMGIDatabase) : AccessTokenDataStore {
    val dao = db.accessTokenDao()
    override suspend fun save(accessToken: AccessTokenEntity) {
        dao.save(accessToken)
    }
}
