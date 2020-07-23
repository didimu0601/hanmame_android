package com.hanname.hbapp.util

enum class ServerType(val code: Int, private val apiUrl: String, private val webUrl: String) {
    REL(Constants.RELSERVER, "http://www.hanname.com/mobile/", "http://www.hanname.com/mobile/"),
    DEV(Constants.DEVSERVER, "http://www.hanname.com/mobile/", "http://www.hanname.com/mobile/"),
    QA(Constants.QASERVER, "http://www.hanname.com/mobile/", "http://www.hanname.com/mobile/"),
    SSLREL(Constants.SSLRELSERVER, "http://www.hanname.com/mobile/", "http://www.hanname.com/mobile/"),
    SSLDEV(Constants.SSLDEVSERVER, "http://www.hanname.com/mobile/", "http://www.hanname.com/mobile/"),
    SSLQA(Constants.SSLQASERVER, "http://www.hanname.com/mobile/", "http://www.hanname.com/mobile/");

    fun getServerCode(): Int {
        return this.code
    }

    fun getApiUrl(): String {
        return this.apiUrl
    }

    fun getWebUrl(): String {
        return this.webUrl
    }

    fun test() {
        for (type: ServerType in values()) {
        }
    }

    companion object {
        var apiUrl: String = REL.getApiUrl()
        var webUrl: String = REL.getWebUrl()

        fun from(findValue: Int?): ServerType {
            var type = REL
            findValue ?: return type

            try {
                type = values().first { it.code == findValue }
            } catch (e: Exception) {
                e.printStackTrace()
            }
            return type
        }
    }
}