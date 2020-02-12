package com.treeengineering.model.request

data class AccessTokenRequest(
    val client_id: String,
    val client_secret: String,
    val code: String
)
