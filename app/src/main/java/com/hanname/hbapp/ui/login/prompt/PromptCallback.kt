package com.hanname.hbapp.ui.login.prompt

interface PromptCallback {
    fun onSuccess()
    fun onHelp(id: Int)
    fun onFail(id: Int)
}