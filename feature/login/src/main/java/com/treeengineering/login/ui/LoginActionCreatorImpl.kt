package com.treeengineering.login.ui

import android.net.Uri
import android.view.View
import com.treeengineering.core.dispatcher.Dispatcher
import com.treeengineering.core.ext.ManifestUtil
import com.treeengineering.db.entity.AccessTokenEntity
import com.treeengineering.db.entity.UserEntity
import com.treeengineering.model.request.AccessTokenRequest
import com.treeengineering.repository.LoginRepository
import com.treeengineering.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class LoginActionCreatorImpl(
    private val dispatcher: Dispatcher,
    private val loginRepository: LoginRepository,
    private val userRepository: UserRepository,
    private val manifestUtil: ManifestUtil
) : LoginActionCreator {

    override fun login(authUri: String?) {
        GlobalScope.launch(Dispatchers.Main) {
            dispatcher.dispatch(LoginAction.ProgressAction(View.VISIBLE))
            val accessToken = loginRepository.getAccessToken()
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
                val response = loginRepository.requestAccessToken(
                    AccessTokenRequest(
                        client_id = manifestUtil.getClientId() ?: "",
                        client_secret = manifestUtil.getClientSecret() ?: "",
                        code = code
                    )
                )
                loginRepository.saveAccessToken(AccessTokenEntity(response.access_token))
                dispatcher.dispatch(LoginAction.SavedAccessTokenAction(true))
            }
            dispatcher.dispatch(LoginAction.ProgressAction(View.GONE))
        }
    }

    override fun fetchUser() {
        GlobalScope.launch(Dispatchers.Main) {
            val userName = userRepository.getUserName()
            if (userName.isEmpty()) {
                val user = userRepository.getUser()
                userRepository.saveUser(
                    UserEntity(
                        0,
                        login = user.login,
                        html_url = user.html_url,
                        name = user.name,
                        bio = user.name,
                        avatar_url = user.name
                    )
                )
            }
            dispatcher.dispatch(LoginAction.SavedUserAction(true))
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
}
