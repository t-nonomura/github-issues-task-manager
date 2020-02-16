package com.treeengineering.login.ui

interface LoginActionCreator {
    fun login(authUri: String?)

    fun checkAccessToken()
}
