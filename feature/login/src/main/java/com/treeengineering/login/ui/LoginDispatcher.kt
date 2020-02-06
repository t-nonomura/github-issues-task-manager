package com.treeengineering.login.ui

import com.treeengineering.core.dispatcher.Dispatcher
import io.reactivex.Flowable
import io.reactivex.processors.BehaviorProcessor
import io.reactivex.processors.FlowableProcessor

class LoginDispatcher : Dispatcher() {

    private val dispatcherOAuth: FlowableProcessor<LoginAction.OAuthBrowserRequestAction>
            = BehaviorProcessor.create<LoginAction.OAuthBrowserRequestAction>().toSerialized()

    val onOAuthBrowserRequest: Flowable<LoginAction.OAuthBrowserRequestAction> = dispatcherOAuth

    fun dispatch(action: LoginAction.OAuthBrowserRequestAction) {
        dispatcherOAuth.onNext(action)
    }
}
