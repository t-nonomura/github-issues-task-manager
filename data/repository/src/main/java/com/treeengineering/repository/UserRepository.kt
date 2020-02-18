package com.treeengineering.repository

import com.treeengineering.model.response.User

interface UserRepository {
    suspend fun getUser(): User
}
