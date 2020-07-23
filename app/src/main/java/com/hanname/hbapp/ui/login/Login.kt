package com.hanname.hbapp.ui.login

import com.hanname.hbapp.BasePresenter
import com.hanname.hbapp.BaseView
import com.hanname.hbapp.data.dto.LoginRequest

interface Login {

    interface View: BaseView<Presenter> {
        val isActive: Boolean
        fun checkPromptDevice(isRegister: Boolean = false)
        fun successLogin(loginInfo: LoginRequest, isPromptLogin: Boolean = false)
        fun failLogin(isWrong: Boolean)
        fun successPromptLogin()
        fun helpPromptLogin(id: Int)
        fun failPromptLogin(id: Int)
    }

    interface Presenter: BasePresenter<View> {
        fun registerPromptDevice(deviceId: String, id: String)
        fun removePromptDevice(deviceId: String) //20191018 psg
        fun confirmPromptDevice(deviceId: String, id: String)
        fun doLogin(loginInfo: LoginRequest, isPromptLogin: Boolean = false)
        fun doPromptLogin()
        fun cancelPromptLogin()
    }
}