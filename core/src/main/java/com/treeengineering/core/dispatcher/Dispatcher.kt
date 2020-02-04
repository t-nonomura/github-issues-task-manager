package com.treeengineering.core.dispatcher

import com.treeengineering.core.action.Action


interface Dispatcher {
    suspend fun dispatch(action: Action)

    fun launchAndDispatch(action: Action)
}
