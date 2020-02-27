package com.treeengineering.login.ui

import android.net.Uri
import com.treeengineering.core.action.Action

sealed class LoginAction : Action() {
    data class CodeRequestAction(val uri: Uri) : LoginAction()

    data class SavedAccessTokenAction(val saved: Boolean) : LoginAction()

    data class ProgressAction(val visible: Int) : LoginAction()

    data class SavedUserAction(val saved: Boolean) : LoginAction()
}
