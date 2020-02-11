package com.treeengineering.login.ui

import android.os.Bundle
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

    override fun login(bundle: Bundle?) {
        CoroutineScope(Dispatchers.Main).launch {
            dispatcher.dispatch(LoginAction.ProgressAction(View.VISIBLE))
            if (bundle == null) {
                // 未認証
                dispatcher.dispatch(LoginAction.OAuthBrowserRequestAction(request = true))
            } else {

            }
            dispatcher.dispatch(LoginAction.ProgressAction(View.GONE))
        }
    }
}
