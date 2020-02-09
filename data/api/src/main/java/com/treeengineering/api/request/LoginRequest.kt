package com.treeengineering.api.request

data class LoginRequest(
    val client_id: String,
    val client_secret: String,
    val code: String,
    val redirect_uri: String?,
    val state: String?
)
