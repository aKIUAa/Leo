package com.xio.leo.ueo.core

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

/**
 * Every module pulls dispatchers from here instead of calling
 * Dispatchers.IO / Dispatchers.Default directly — so the JVM bridge,
 * downloads, etc. can be swapped or tested without touching every
 * module that uses them.
 */
interface AppDispatchers {
    val io: CoroutineDispatcher
    val default: CoroutineDispatcher
    val main: CoroutineDispatcher
}

object DefaultAppDispatchers : AppDispatchers {
    override val io: CoroutineDispatcher = Dispatchers.IO
    override val default: CoroutineDispatcher = Dispatchers.Default
    override val main: CoroutineDispatcher = Dispatchers.Main
}
