package com.soundapp.session.signup.presenter

import com.abecerra.base.presentation.BasePresenter
import com.soundapp.session.signup.view.SignUpView

interface SignUpPresenter : BasePresenter<SignUpView> {

    fun onSignUpWithEmailClicked(userName: String, password: String)
}