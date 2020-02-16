package com.treeengineering.db.dao

import androidx.room.Dao
import androidx.room.Insert
import com.treeengineering.db.entity.AccessTokenEntity

@Dao
interface AccessTokenDao {
    @Insert
    suspend fun save(accessTokenEntity: AccessTokenEntity)
}
