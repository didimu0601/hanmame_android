package com.hanname.hbapp.ui.main

import com.hanname.hbapp.BasePresenter
import com.hanname.hbapp.BaseView

interface Main {
    interface View : BaseView<Presenter> {
        val isActive: Boolean
        fun checkVersion(isForceUpdate: Boolean = false, isUpdate: Boolean = false)
        fun checkTermsAgree()
    }

    interface Presenter : BasePresenter<View> {
        fun requestVersion(version: String)
        fun doAutoLogin(id:String, pw:String)
    }
}