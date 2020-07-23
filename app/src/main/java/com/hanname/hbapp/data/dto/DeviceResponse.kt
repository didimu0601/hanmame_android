package com.hanname.hbapp.data.dto

data class DeviceResponse(val resultContent : /*String*/DeviceContent) : Base() {
    data class DeviceContent(val regDate: String)
}