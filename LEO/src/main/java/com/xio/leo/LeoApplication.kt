package com.xio.leo

import android.app.Application
import com.xio.leo.ueo.core.AppContainer

class LeoApplication : Application() {
    lateinit var container: AppContainer
        private set

    override fun onCreate() {
        super.onCreate()
        container = AppContainer(this)
    }
}
