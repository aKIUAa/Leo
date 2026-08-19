package com.xio.leo.ueo.core

import android.content.Context

/**
 * Manual object graph, built once in LeoApplication and handed down.
 * CREDITS/MOJANG/MINECRAFT/LEI each add their own lazy entry here
 * once those modules exist.
 */
class AppContainer(private val appContext: Context) {
    val dispatchers: AppDispatchers = DefaultAppDispatchers
    val preferences: LeoPreferences by lazy { LeoPreferences(appContext) }
}
