package com.hanname.hbapp.di

import android.content.Context
import com.hanname.hbapp.HybridApp
import com.hanname.hbapp.BuildConfig
import com.hanname.hbapp.api.HttpApi
import com.hanname.hbapp.data.repository.remote.ReceivedCookiesInterceptor
import com.hanname.hbapp.util.PrintLog
import com.hanname.hbapp.util.ServerType
import com.hanname.hbapp.util.SharedPref
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton


@Module
class AppModule {
    @Singleton
    @Provides
    @Named("application.context")
    internal fun provideApplicationContext(hybridApp: HybridApp): Context = hybridApp.applicationContext

    @Singleton
    @Provides
    fun provideHttpService(@Named("application.context")application: Context): HttpApi {
        val interceptor = HttpLoggingInterceptor()
        if (BuildConfig.DEBUG) {
            interceptor.level = HttpLoggingInterceptor.Level.BODY
        }
        val client = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .addInterceptor(ReceivedCookiesInterceptor())
            .build()

        if (BuildConfig.DEBUG) {
           ServerType.apiUrl = ServerType.from(SharedPref.getInstance().getInt(SharedPref.PREF_SERVER_MODE)).getApiUrl()
           ServerType.webUrl = ServerType.from(SharedPref.getInstance().getInt(SharedPref.PREF_SERVER_MODE)).getWebUrl() //khm test
            //ServerType.apiUrl = ServerType.from(1).getApiUrl()//khm test
        } else {
           ServerType.apiUrl = ServerType.REL.getApiUrl()
        }

        PrintLog.d("ham", "httpService url " + ServerType.apiUrl)
        return Retrofit.Builder()
            .baseUrl(ServerType.apiUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
            .create(HttpApi::class.java)
    }
}