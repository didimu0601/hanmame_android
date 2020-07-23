package com.hanname.hbapp.ui.settings

import com.hanname.hbapp.BasePresenter
import com.hanname.hbapp.BaseView

interface Settings {

    interface View : BaseView<Presenter> {
        val isActive: Boolean
    }

    interface Presenter : BasePresenter<View>
}
