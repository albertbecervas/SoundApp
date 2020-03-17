package com.abecerra.soundapp.navigation.routers

import android.content.Intent
import androidx.fragment.app.Fragment
import com.abecerra.soundapp.navigation.navigator.Navigator
import com.abecerra.soundapp.scenes.main.view.MainActivity
import com.diet.session.login.router.LoginRouter
import com.diet.session.login.view.LoginFragment

class LoginRouterImpl(private val navigator: Navigator) : LoginRouter {

    override fun launchGoogleSignIn(intent: Intent, resultCode: Int, fragment: Fragment) {
        navigator.startActivityForResult(intent, LoginFragment.GOOGLE_SIGN_IN, fragment)
    }

    override fun onSignUpClicked() {

    }

    override fun onUserLogged() {
        navigator.startActivity(MainActivity::class.java)
    }
}