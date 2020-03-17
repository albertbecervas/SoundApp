package com.abecerra.soundapp.navigation.routers

import com.abecerra.soundapp.R
import com.abecerra.soundapp.navigation.navigator.Navigator
import com.abecerra.soundapp.scenes.launcher.router.LauncherRouter
import com.abecerra.soundapp.scenes.main.view.MainActivity
import com.diet.session.login.view.LoginFragment

class LauncherRouterImpl(
    private val navigator: Navigator,
    private val loginFragment: LoginFragment
) : LauncherRouter {

    override fun showLogin() {
        navigator.replaceFragment(loginFragment, R.id.fl)
    }

    override fun navigateToHome() {
        navigator.startActivityFinishingCurrent(MainActivity::class.java)
    }
}