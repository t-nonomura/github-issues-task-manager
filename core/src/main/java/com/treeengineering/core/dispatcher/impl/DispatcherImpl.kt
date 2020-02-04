package com.treeengineering.core.dispatcher.impl

import com.treeengineering.core.action.Action
import com.treeengineering.core.dispatcher.Dispatcher
import com.treeengineering.core.ext.CoroutinePlugin
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.BroadcastChannel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext


class DispatcherImpl : Dispatcher {
    private val _actions = BroadcastChannel<Action>(Channel.CONFLATED)
    val events: ReceiveChannel<Action> get() = _actions.openSubscription()

    inline fun <reified T : Action> subscribe(): ReceiveChannel<T> {
        return events.filterAndCast()
    }

    override suspend fun dispatch(action: Action) {
        withContext(CoroutinePlugin.mainDispatcher) {
            _actions.send(action)
        }
    }

    override fun launchAndDispatch(action: Action) {
        GlobalScope.launch(CoroutinePlugin.mainDispatcher) {
            _actions.send(action)
        }
    }

    inline fun <reified E, reified R : E> ReceiveChannel<E>.filterAndCast(
        context: CoroutineContext = Dispatchers.Unconfined
    ): ReceiveChannel<R> =
        GlobalScope.produce(context, capacity = Channel.UNLIMITED) {
            consumeEach { e ->
                (e as? R)?.let { send(it) }
            }
        }
}
