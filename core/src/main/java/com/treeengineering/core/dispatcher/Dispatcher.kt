package com.treeengineering.core.dispatcher

import com.treeengineering.core.action.Action
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.*
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

class Dispatcher {
    private val actions = BroadcastChannel<Action>(Channel.CONFLATED)
    val events: ReceiveChannel<Action> get() = actions.openSubscription()

    inline fun <reified T : Action> subscribe(): ReceiveChannel<T> {
        return events.filterAndCast()
    }

    suspend fun dispatch(action: Action) {
        withContext(Dispatchers.Main) {
            actions.send(action)
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
