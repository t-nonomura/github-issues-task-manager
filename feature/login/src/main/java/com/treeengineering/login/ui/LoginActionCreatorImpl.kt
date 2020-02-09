package com.treeengineering.login.ui

import android.view.View
import com.treeengineering.core.dispatcher.Dispatcher
import com.treeengineering.repository.LoginRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginActionCreatorImpl(
    private val dispatcher: Dispatcher,
    private val repository: LoginRepository
) : LoginActionCreator {

    override fun login() {
        CoroutineScope(Dispatchers.Main).launch {
            dispatcher.dispatch(LoginAction.ProgressAction(View.VISIBLE))
            val Authenticated = false
            if (Authenticated) {
                // 認証済み

            } else {
                // 未認証
                dispatcher.dispatch(LoginAction.OAuthBrowserRequestAction(request = true))
            }
            dispatcher.dispatch(LoginAction.ProgressAction(View.GONE))
        }
    }
}
