package com.abecerra.soundapp.scenes.main.router

import androidx.annotation.IdRes

interface MainRouter {
    fun loadDefaultFragment(@IdRes layout: Int)
}