package com.abecerra.soundapp.scenes.main.router

import androidx.annotation.IdRes
import com.abecerra.soundapp.R

interface MainRouter {
    fun loadHomeFragment(@IdRes layout: Int = R.id.base_fl)
    fun loadSearchFragment(@IdRes layout: Int = R.id.base_fl)
    fun loadProfileFragment()
}