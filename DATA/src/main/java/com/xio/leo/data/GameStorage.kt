package com.xio.leo.data

import android.content.Context
import java.io.File

/**
 * Leo's default game storage — the app-specific external directory.
 * Zero permissions required on any Android version. This is where
 * .minecraft actually lives.
 */
object GameStorage {

    private const val GAME_DIR_NAME = ".minecraft"

    fun defaultGameDir(context: Context): File {
        val base = context.getExternalFilesDir(null) ?: context.filesDir
        val gameDir = File(base, GAME_DIR_NAME)
        if (!gameDir.exists()) gameDir.mkdirs()
        return gameDir
    }
}
