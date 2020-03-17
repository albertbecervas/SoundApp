package com.abecerra.soundapp.navigation.routers

import com.abecerra.soundapp.navigation.navigator.Navigator
import com.abecerra.soundapp.scenes.main.router.MainRouter
import javax.inject.Inject

class MainRouterImpl @Inject constructor(
    private val navigator: Navigator
) : MainRouter {
    override fun loadDefaultFragment(layout: Int) {
    }
}