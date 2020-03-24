package com.abecerra.soundapp.navigation.routers

import com.abecerra.soundapp.navigation.navigator.Navigator
import com.abecerra.soundapp.scenes.main.view.MainActivity
import com.soundapp.session.signup.router.SignUpRouter

class SignUpRouterImpl(private val navigator: Navigator) : SignUpRouter {
    override fun onUserSignedUp() {
        navigator.startActivityFinishingCurrent(MainActivity::class.java)
    }
}