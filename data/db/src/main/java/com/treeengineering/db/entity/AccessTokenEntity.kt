package com.treeengineering.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "access_token")
data class AccessTokenEntity(
    @PrimaryKey
    val accessToken: String
)
