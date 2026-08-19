package com.xio.leo.ueo.core

import android.content.Context
import androidx.core.content.edit

/**
 * Simple app-wide settings only (first-run flags, selected theme).
 * NOT for auth tokens or anything sensitive — Microsoft/Mojang tokens
 * need EncryptedSharedPreferences or Keystore-backed storage, which
 * belongs in MOJANG when we build it, not here.
 */
class LeoPreferences(context: Context) {
    private val prefs = context.getSharedPreferences("leo_prefs", Context.MODE_PRIVATE)

    var isFirstLaunch: Boolean
        get() = prefs.getBoolean(KEY_FIRST_LAUNCH, true)
        set(value) = prefs.edit { putBoolean(KEY_FIRST_LAUNCH, value) }

    companion object {
        private const val KEY_FIRST_LAUNCH = "first_launch"
    }
}
