package com.hanname.hbapp.data.repository

import com.hanname.hbapp.api.HttpCallback
import com.hanname.hbapp.data.dto.DeviceRegistration
import com.hanname.hbapp.data.dto.DeviceResponse
import com.hanname.hbapp.data.dto.LoginResponse
import com.hanname.hbapp.data.dto.Version
import com.hanname.hbapp.data.repository.remote.ServiceRemoteData
import com.google.gson.JsonObject
import javax.inject.Inject

//khm remoteService를 자동으로 provide해줌
class ServiceRepository @Inject constructor(private val remoteService: ServiceRemoteData) {

    fun requestVersion(version: String, callback: HttpCallback<Version>.() -> Unit) {
        remoteService.requestVersion(version, callback)
    }

    fun registerPromptDevice(deviceInfo: JsonObject, callback: HttpCallback<DeviceRegistration>.() -> Unit) {
        remoteService.registerPromptDevice(deviceInfo, callback)
    }

    fun confirmPromptDevice(deviceId: String, userId: String, callback: HttpCallback<DeviceResponse>.() -> Unit) {
        remoteService.confirmPromptDevice(deviceId, userId, callback)
    }

    fun doLogin(loginInfo: JsonObject, callback: HttpCallback<LoginResponse>.() -> Unit) {
        remoteService.doLogin(loginInfo, callback)
    }

    // 20191018 psg remove prompt device
    fun removePromptDevice(deviceInfo: JsonObject, callback: HttpCallback<DeviceRegistration>.() -> Unit) {
        remoteService.removePromptDevice(deviceInfo, callback)
    }
}