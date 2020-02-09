package com.treeengineering.core.ext

import androidx.annotation.MainThread
import androidx.lifecycle.LiveData
import com.treeengineering.core.store.Store
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.launch

@MainThread
fun <T> ReceiveChannel<T>.toLiveData(
    store: Store,
    defaultValue: T? = null
): LiveData<T> {
    return object : LiveData<T>(), CoroutineScope by GlobalScope {
        init {
            if (defaultValue != null) {
                value = defaultValue
            }
            val job = launch(CoroutinePlugin.mainDispatcher) {
                for (element in this@toLiveData) {
                    postValue(element)
                }
            }
            store.addHook { job.cancel() }
        }
    }
}
