package com.xio.leo.ueo.core

import android.util.Log

/**
 * Everything logs through here instead of android.util.Log directly.
 * CREDITS/MOJANG/MINECRAFT will need launch + crash logs a phone user
 * can find and share for bug reports — routing through one object now
 * means we can add a file sink later without touching every call site.
 */
object LeoLogger {
    private const val ROOT_TAG = "Leo"
    var enabled: Boolean = true

    fun d(tag: String, message: String) {
        if (enabled) Log.d("$ROOT_TAG/$tag", message)
    }

    fun i(tag: String, message: String) {
        if (enabled) Log.i("$ROOT_TAG/$tag", message)
    }

    fun w(tag: String, message: String, throwable: Throwable? = null) {
        if (enabled) Log.w("$ROOT_TAG/$tag", message, throwable)
    }

    fun e(tag: String, message: String, throwable: Throwable? = null) {
        if (enabled) Log.e("$ROOT_TAG/$tag", message, throwable)
    }
}
