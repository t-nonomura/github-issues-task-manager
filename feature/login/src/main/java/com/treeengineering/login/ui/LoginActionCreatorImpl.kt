package com.treeengineering.login.ui

import com.treeengineering.repository.LoginRepository

class LoginActionCreatorImpl(
    private val dispatcher: LoginDispatcher,
    private val repository: LoginRepository
) : LoginActionCreator {

    fun login()  {
        if (false) {
            // 認証済み

        } else {
            // 未認証
            dispatcher.dispatch(LoginAction.OAuthBrowserRequestAction(request = true))
        }
    }
}
