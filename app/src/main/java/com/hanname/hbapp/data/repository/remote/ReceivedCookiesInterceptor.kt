package com.hanname.hbapp.data.repository.remote

import android.webkit.CookieManager
import com.hanname.hbapp.util.PrintLog
import com.hanname.hbapp.util.ServerType
import com.hanname.hbapp.util.SharedPref
import com.hanname.hbapp.util.Utils
import okhttp3.Interceptor
import okhttp3.Response
import java.util.*


class ReceivedCookiesInterceptor : Interceptor {
    private val TAG by lazy {  ReceivedCookiesInterceptor::class.java.simpleName }

    override fun intercept(chain: Interceptor.Chain): Response {
        val originalResponse = chain.proceed(chain.request())

        if (originalResponse.headers("Set-Cookie").isNotEmpty()) {
            val cookies = HashSet<String>()

            for (header in originalResponse.headers("Set-Cookie")) {
                cookies.add(header)
                CookieManager.getInstance().setCookie(ServerType.webUrl, header)
                PrintLog.d(TAG, "ServerType.webUrl ${ServerType.webUrl} header $header")
            }

            Utils.flushCookies()
            PrintLog.d(TAG, "cookies $cookies")
            SharedPref.getInstance().setStringSet(SharedPref.PREF_COOKIES, cookies)
        }

        return originalResponse
    }

}