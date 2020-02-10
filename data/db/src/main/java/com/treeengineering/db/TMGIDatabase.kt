package com.treeengineering.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters


@Database(
    entities = [],
    version = 1
)
@TypeConverters(TMGIDatabaseConverter::class)
abstract class TMGIDatabase : RoomDatabase() {

}
