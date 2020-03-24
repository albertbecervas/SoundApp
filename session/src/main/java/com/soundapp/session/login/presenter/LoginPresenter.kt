package com.soundapp.session.login.presenter

import android.content.Intent
import com.abecerra.base.presentation.BasePresenter
import com.soundapp.session.login.view.LoginView
import com.soundapp.session.signup.view.SignUpView

interface LoginPresenter : BasePresenter<LoginView> {

    fun onLoginClicked(username: String, password: String)

    fun onSignUpWithEmailClicked()

    fun onSignInWithGoogleClicked()

    fun onSignInWithGoogleResult(data: Intent?)
}