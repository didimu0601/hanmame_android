package com.hanname.hbapp.data.repository.remote

import com.google.gson.JsonObject
import com.hanname.hbapp.api.HttpApi
import com.hanname.hbapp.api.HttpCallback
import com.hanname.hbapp.data.dto.DeviceRegistration
import com.hanname.hbapp.data.dto.DeviceResponse
import com.hanname.hbapp.data.dto.LoginResponse
import com.hanname.hbapp.data.dto.Version
import com.hanname.hbapp.data.repository.ServiceData
import com.hanname.hbapp.util.Constants

import retrofit2.Call
import javax.inject.Inject

class ServiceRemoteData @Inject constructor(private val httpApi: HttpApi) : ServiceData {

    fun registerPromptDevice(deviceInfo: JsonObject, callback: HttpCallback<DeviceRegistration>.() -> Unit) {
        httpApi.registerPromptDevice(deviceInfo).enqueue(callback)
    }

    fun confirmPromptDevice(deviceId: String, userId: String, callback: HttpCallback<DeviceResponse>.() -> Unit) {
        httpApi.confirmPromptDevice(deviceId, userId).enqueue(callback)
    }

    fun requestVersion(version:String, callback: HttpCallback<Version>.() -> Unit) {
        httpApi.requestVersion(Constants.HYBRID_SITE_ID,"android" ).enqueue(callback)
    }

    fun doLogin(loginInfo: JsonObject, callback: HttpCallback<LoginResponse>.() -> Unit) {
        val userid : String = loginInfo.get("userid").asString ?: ""
        val passwd : String= loginInfo.get("passwd").asString ?: ""

        httpApi.login(userid,passwd,Constants.HYBRID_SITE_ID ,"0" ).enqueue(callback)
    }

    // 20191018 psg remove prompt device
    fun removePromptDevice(deviceInfo: JsonObject, callback: HttpCallback<DeviceRegistration>.() -> Unit) {
        httpApi.removePromptDevice(deviceInfo).enqueue(callback)
    }

    private fun<T> Call<T>.enqueue(callback: HttpCallback<T>.() -> Unit) {
        val httpCallback = HttpCallback<T>()
        callback.invoke(httpCallback)
        this.enqueue(httpCallback)
    }
}