package com.treeengineering.db.datastore

import com.treeengineering.db.TMGIDatabase
import com.treeengineering.db.entity.UserEntity

class UserDataStoreImpl(db: TMGIDatabase) : UserDataStore {
    private val dao = db.userDao()
    override suspend fun save(userEntity: UserEntity) {
        dao.save(userEntity)
    }

    override suspend fun getUserName(): String {
        return dao.getUserName() ?: ""
    }
}
