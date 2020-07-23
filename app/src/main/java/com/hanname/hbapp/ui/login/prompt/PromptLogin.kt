package com.hanname.hbapp.ui.login.prompt

interface PromptLogin {
    fun authenticate(callback: PromptCallback)
    fun cancel()
}