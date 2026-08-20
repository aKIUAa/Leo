package com.xio.leo

import android.app.Activity
import android.os.Bundle
import android.widget.TextView
import com.xio.leo.data.GameStorage

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val gameDir = GameStorage.defaultGameDir(this)
        setContentView(TextView(this).apply {
            text = "Leo — infrastructure online.\nGame dir: ${gameDir.absolutePath}"
            textSize = 18f
        })
    }
}
