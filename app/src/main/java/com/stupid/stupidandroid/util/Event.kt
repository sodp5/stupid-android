package com.stupid.stupidandroid.util

import kotlinx.coroutines.flow.Flow

open class Event<out T>(private val content: T) {
    var hasBeenHandled = false
        private set

    fun getContentIfNotHandled(): T? {
        return if (hasBeenHandled) {
            null
        } else {
            hasBeenHandled = true
            content
        }
    }

    fun peekContent(): T = content
}

suspend inline fun<T> Flow<Event<T>>.collectOnce(crossinline collector: (T) -> Unit) {
    collect { event ->
        event.getContentIfNotHandled()?.also {
            collector(it)
        }
    }
}
