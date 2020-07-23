package com.hanname.hbapp

import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import dagger.android.AndroidInjection
import com.hanname.hbapp.ui.dialog.CustomAlertDialog
import com.hanname.hbapp.ui.login.LoginActivity
import com.hanname.hbapp.ui.main.MainActivity
import com.hanname.hbapp.util.Utils

abstract class BaseActivity : AppCompatActivity() {
    var isBackPressed: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
    }

    override fun onBackPressed() {
        if (this is MainActivity
            || this is LoginActivity //20191023 psg login activity same logic
        ) {
            finishApplication()
            return
        }
        super.onBackPressed()
    }

    fun failHttp() {
        CustomAlertDialog.Builder(this).apply {
            setMsg(msgId = R.string.msg_http_fail)
            setPositiveButton(positiveId = android.R.string.ok)
        }.build()
    }

    private fun finishApplication() {
        if (isBackPressed) {
            super.onBackPressed()
            Utils.finishApplication(this)
        } else {
            isBackPressed = true
            if (!isFinishing && !isDestroyed) {
                Toast.makeText(this, R.string.msg_finish_application, Toast.LENGTH_SHORT).show()
            }
            Handler().postDelayed({ isBackPressed = false }, 2000)
        }
    }

}
