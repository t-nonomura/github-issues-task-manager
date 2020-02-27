package com.treeengineering.model.response

data class User(
    val id: Long,
    val login: String,
    val html_url: String,
    val name: String,
    val bio: String,
    val avatar_url: String
)
