package com.hanname.hbapp

interface BasePresenter<T> {
    fun start(view: T)
}