package com.hanname.hbapp.ui.settings

import com.hanname.hbapp.data.repository.ServiceRepository
import javax.inject.Inject

class SettingsPresenter @Inject constructor(val repository: ServiceRepository) : Settings.Presenter { //khm currently not used, but for later

    private val TAG by lazy {  SettingsPresenter::class.java.simpleName }

    private lateinit var settingsView: Settings.View

    override fun start(view: Settings.View) {
        settingsView = view
    }

}
