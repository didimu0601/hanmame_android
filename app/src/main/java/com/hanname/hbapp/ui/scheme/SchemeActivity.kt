package com.hanname.hbapp.ui.scheme

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.hanname.hbapp.ui.main.MainActivity
import com.hanname.hbapp.util.PrintLog

class SchemeActivity : AppCompatActivity() { //not use appBar
    private val TAG by lazy {  SchemeActivity::class.java.simpleName }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        PrintLog.d(TAG, "onCreate")
        handleIntent(intent)
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        PrintLog.d(TAG, "onNewIntent")
        handleIntent(intent)
    }

    private fun handleIntent(intent: Intent?) {
        PrintLog.d(TAG, "handleIntent")
        val schemeIntent = Intent(this@SchemeActivity, MainActivity::class.java)
            .apply {
                data = intent?.data
                flags = Intent.FLAG_ACTIVITY_CLEAR_TOP and Intent.FLAG_ACTIVITY_SINGLE_TOP
            }
        startActivity(schemeIntent)
    }
}
