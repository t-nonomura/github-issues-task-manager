package com.treeengineering.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.treeengineering.db.dao.AccessTokenDao
import com.treeengineering.db.dao.UserDao
import com.treeengineering.db.entity.AccessTokenEntity
import com.treeengineering.db.entity.UserEntity


@Database(
    entities = [
        AccessTokenEntity::class,
        UserEntity::class
    ],
    version = 1
)
@TypeConverters(TMGIDatabaseConverter::class)
abstract class TMGIDatabase : RoomDatabase() {
    abstract fun accessTokenDao(): AccessTokenDao

    abstract fun userDao(): UserDao
}
