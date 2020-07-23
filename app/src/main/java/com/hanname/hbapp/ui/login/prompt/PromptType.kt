package com.hanname.hbapp.ui.login.prompt

import javax.inject.Qualifier

@Qualifier
@MustBeDocumented
@Retention(value = AnnotationRetention.RUNTIME)
annotation class PromptType(val value: String = "")