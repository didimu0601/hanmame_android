package com.hanname.hbapp

interface BaseView<T> {
    var presenter: T
    fun onHttpFailure()
}