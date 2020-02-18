package com.treeengineering.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.treeengineering.db.entity.UserEntity

@Dao
interface UserDao {
    @Insert
    suspend fun save(userEntity: UserEntity)

    @Query("SELECT login FROM user")
    suspend fun getUserName(): String?
}
