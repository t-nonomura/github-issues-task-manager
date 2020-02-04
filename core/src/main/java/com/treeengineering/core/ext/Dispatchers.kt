package com.treeengineering.core.ext

object Dispatchers {
    val Main get() = CoroutinePlugin.mainDispatcher
    val IO get() = CoroutinePlugin.ioDispatcher
    val Default get() = CoroutinePlugin.defaultDispatcher
}
