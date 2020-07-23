package com.hanname.hbapp.di

import com.hanname.hbapp.ui.login.LoginActivity
import com.hanname.hbapp.ui.login.LoginModule
import com.hanname.hbapp.ui.login.prompt.PromptModule
import com.hanname.hbapp.ui.main.MainActivity
import com.hanname.hbapp.ui.main.MainModule
import com.hanname.hbapp.ui.settings.SettingsActivity
import com.hanname.hbapp.ui.settings.SettingsModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {

    @ActivityScoped
    @ContributesAndroidInjector(modules = [MainModule::class]) //ContributesAndroidInjector는 Module(여기선 ActivityBindingModule)에서 각 Activity별 subComponent생성
    abstract fun mainActivity(): MainActivity

    @ActivityScoped
    @ContributesAndroidInjector(modules = [LoginModule::class, PromptModule::class]) //modules는 생성된 subComponent와 연결할 모듈을 정의
    abstract fun loginActivity(): LoginActivity

    @ActivityScoped
    @ContributesAndroidInjector(modules = [SettingsModule::class])
    abstract fun settingsActivity(): SettingsActivity
}