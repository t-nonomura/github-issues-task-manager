package com.treeengineering.db

import android.content.Context
import androidx.room.Room

object TMGIDatabaseFactory {
    fun create(context: Context): TMGIDatabase {
        return Room.databaseBuilder(
            context,
            TMGIDatabase::class.java,
            "tmgi.db"
        ).build()
    }
}
