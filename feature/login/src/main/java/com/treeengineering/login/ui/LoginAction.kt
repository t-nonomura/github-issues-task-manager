package com.treeengineering.login.ui

import com.treeengineering.core.action.Action

sealed class LoginAction : Action() {
    data class OAuthBrowserRequestAction(val request: Boolean) : LoginAction()

    data class ProgressAction(val visible: Int) : LoginAction()
}
