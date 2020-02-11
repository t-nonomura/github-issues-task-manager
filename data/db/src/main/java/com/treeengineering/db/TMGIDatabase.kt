package com.treeengineering.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.treeengineering.db.entity.AccessTokenEntity


@Database(
    entities = [AccessTokenEntity::class],
    version = 1
)
@TypeConverters(TMGIDatabaseConverter::class)
abstract class TMGIDatabase : RoomDatabase() {

}
