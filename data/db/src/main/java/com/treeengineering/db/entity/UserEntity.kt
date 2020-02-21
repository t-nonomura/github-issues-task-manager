package com.treeengineering.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class UserEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val login: String,
    val html_url: String,
    val name: String,
    val bio: String,
    val avatar_url: String
)
