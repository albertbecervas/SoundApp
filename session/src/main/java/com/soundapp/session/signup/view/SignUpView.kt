package com.soundapp.session.signup.view

import com.abecerra.base.presentation.BaseView

interface SignUpView : BaseView {

    fun showErrorOnUsernameField(errorMessage: String)

    fun showErrorOnPasswordField(errorMessage: String)
}