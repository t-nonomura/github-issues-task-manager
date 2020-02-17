package com.treeengineering.login.ui

import android.net.Uri
import android.view.View
import com.treeengineering.core.dispatcher.Dispatcher
import com.treeengineering.core.ext.ManifestUtil
import com.treeengineering.db.entity.AccessTokenEntity
import com.treeengineering.model.request.AccessTokenRequest
import com.treeengineering.repository.LoginRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginActionCreatorImpl(
    private val dispatcher: Dispatcher,
    private val repository: LoginRepository,
    private val manifestUtil: ManifestUtil
) : LoginActionCreator {

    override fun login(authUri: String?) {
        CoroutineScope(Dispatchers.Main).launch {
            dispatcher.dispatch(LoginAction.ProgressAction(View.VISIBLE))
            val accessToken = repository.getAccessToken()
            if (accessToken.isNotEmpty()) {
                // 既にAccessTokenを保存済み
                dispatcher.dispatch(LoginAction.SavedAccessTokenAction(true))
                dispatcher.dispatch(LoginAction.ProgressAction(View.GONE))
                return@launch
            }

            if (authUri == null) {
                // 未認証
                val uriRequestCode = buildUriForRequestCode()
                uriRequestCode?.let {
                    dispatcher.dispatch(LoginAction.CodeRequestAction(it))
                }
            } else {
                // 認証済み
                val code = Uri.parse(authUri).getQueryParameter("code").toString()
                val response = repository.accessToken(
                    AccessTokenRequest(
                        client_id = manifestUtil.getClientId() ?: "",
                        client_secret = manifestUtil.getClientSecret() ?: "",
                        code = code
                    )
                )
                repository.saveAccessToken(AccessTokenEntity(response.access_token))
            }
            dispatcher.dispatch(LoginAction.ProgressAction(View.GONE))
        }
    }

    private fun buildUriForRequestCode(): Uri? {
        val clientId = manifestUtil.getClientId()
        if (clientId.isNullOrEmpty()) return null

        return Uri.parse("https://github.com/login/oauth/authorize")
            .buildUpon()
            .appendQueryParameter("client_id", clientId)
            .appendQueryParameter("scope", "repo")
            .build()
    }

    override fun checkAccessToken() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
