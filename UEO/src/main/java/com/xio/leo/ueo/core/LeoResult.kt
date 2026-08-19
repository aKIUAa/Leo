package com.xio.leo.ueo.core

/**
 * Standard return type for anything that can fail across module
 * boundaries: auth, downloads, file I/O, launching the JVM. One shape
 * means the UI layer always handles errors the same way, instead of
 * every module inventing its own.
 */
sealed class LeoResult<T> {
    data class Success<T>(val value: T) : LeoResult<T>()
    data class Failure<T>(val error: LeoError) : LeoResult<T>()

    inline fun onSuccess(action: (T) -> Unit): LeoResult<T> {
        if (this is Success) action(value)
        return this
    }

    inline fun onFailure(action: (LeoError) -> Unit): LeoResult<T> {
        if (this is Failure) action(error)
        return this
    }
}

data class LeoError(
    val message: String,
    val cause: Throwable? = null,
    val code: String? = null
)
