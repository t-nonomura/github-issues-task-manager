package com.treeengineering.login.ui

import io.reactivex.Flowable
import io.reactivex.processors.BehaviorProcessor
import io.reactivex.processors.FlowableProcessor

class LoginDispatcherImpl : LoginDispatcher {
    /**
     * OAuthによる外部ブラウザでのログインリクエスト
     */
    private val dispatcherOAuth: FlowableProcessor<LoginAction.OAuthBrowserRequestAction> =
        BehaviorProcessor.create<LoginAction.OAuthBrowserRequestAction>().toSerialized()
    override val onOAuthBrowserRequest: Flowable<LoginAction.OAuthBrowserRequestAction> =
        dispatcherOAuth

    override fun dispatch(action: LoginAction.OAuthBrowserRequestAction) {
        dispatcherOAuth.onNext(action)
    }

    /**
     * プログレスの表示制御
     */
    private val dispatcherProgress: FlowableProcessor<LoginAction.ProgressAction> =
        BehaviorProcessor.create<LoginAction.ProgressAction>().toSerialized()
    override val onProgress: Flowable<LoginAction.ProgressAction> = dispatcherProgress
    override fun dispatch(action: LoginAction.ProgressAction) {
        dispatcherProgress.onNext(action)
    }
}
