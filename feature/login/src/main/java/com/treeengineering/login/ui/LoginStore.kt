package com.treeengineering.login.ui

import com.treeengineering.core.dispatcher.Dispatcher
import com.treeengineering.core.ext.toLiveData
import com.treeengineering.core.store.Store
import kotlinx.coroutines.channels.map

class LoginStore(dispatcher: Dispatcher) : Store() {
    val codeRequest = dispatcher
        .subscribe<LoginAction.CodeRequestAction>()
        .map { it.uri }
        .toLiveData(this)

    val accessTokenSaved = dispatcher
        .subscribe<LoginAction.SavedAccessTokenAction>()
        .map { it.saved }
        .toLiveData(this)

    val progress = dispatcher
        .subscribe<LoginAction.ProgressAction>()
        .map { it.visible }
        .toLiveData(this)
}
