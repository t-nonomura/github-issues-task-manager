package com.treeengineering.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.treeengineering.db.entity.AccessTokenEntity

@Dao
interface AccessTokenDao {
    @Insert
    suspend fun save(accessTokenEntity: AccessTokenEntity)

    @Query("SELECT accessToken FROM access_token")
    suspend fun getAccessToken(): String?
}
