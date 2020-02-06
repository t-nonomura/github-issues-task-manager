package com.treeengineering.login.ui

import androidx.lifecycle.LiveData
import com.treeengineering.core.ext.toLiveData
import com.treeengineering.core.store.Store
import io.reactivex.android.schedulers.AndroidSchedulers

class LoginStore(private val dispatcher: LoginDispatcher) : Store() {
    val oAuthBrowserRequest: LiveData<Boolean> = dispatcher.onOAuthBrowserRequest
        .map { it.request }
        .observeOn(AndroidSchedulers.mainThread())
        .toLiveData()
}
