package com.treeengineering.login.ui

import io.reactivex.Flowable

interface LoginDispatcher {
    fun dispatch(action: LoginAction.OAuthBrowserRequestAction)

    val onOAuthBrowserRequest: Flowable<LoginAction.OAuthBrowserRequestAction>

    fun dispatch(action: LoginAction.ProgressAction)

    val onProgress: Flowable<LoginAction.ProgressAction>
}
