package com.abecerra.soundapp.navigation.routers

import android.content.Intent
import androidx.fragment.app.Fragment
import com.abecerra.soundapp.R
import com.abecerra.soundapp.navigation.navigator.Navigator
import com.abecerra.soundapp.scenes.main.view.MainActivity
import com.soundapp.session.login.router.LoginRouter
import com.soundapp.session.login.view.LoginFragment
import com.soundapp.session.signup.view.SignUpFragment

class LoginRouterImpl(
    private val navigator: Navigator,
    private val signUpFragment: SignUpFragment
) : LoginRouter {

    override fun launchGoogleSignIn(intent: Intent, resultCode: Int, fragment: Fragment) {
        navigator.startActivityForResult(intent, LoginFragment.GOOGLE_SIGN_IN, fragment)
    }

    override fun onSignUpClicked() {
        navigator.replaceFragmentAndAddToBackStack(signUpFragment, R.id.fl)
    }

    override fun onUserLogged() {
        navigator.startActivityFinishingCurrent(MainActivity::class.java)
    }
}