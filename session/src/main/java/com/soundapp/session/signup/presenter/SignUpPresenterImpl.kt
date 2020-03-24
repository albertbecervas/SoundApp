package com.soundapp.session.signup.presenter

import com.abecerra.base.presentation.BasePresenterImpl
import com.soundapp.session.authentication.domain.interactor.SessionInteractor
import com.soundapp.session.authentication.domain.interactor.SessionInteractorOutput
import com.soundapp.session.signup.router.SignUpRouter
import com.soundapp.session.signup.view.SignUpView

class SignUpPresenterImpl(
    private val router: SignUpRouter,
    private val sessionInteractor: SessionInteractor
) : BasePresenterImpl<SignUpView>(), SignUpPresenter, SessionInteractorOutput {

    init {
        sessionInteractor.setInteractorOutput(this)
    }

    override fun onSignUpWithEmailClicked(userName: String, password: String) {
        sessionInteractor.signUp(userName, password)
    }

    override fun userIsLogged() {
        router.onUserSignedUp()
    }

    override fun userIsSignedUp() {
        router.onUserSignedUp()
    }

    override fun userNameIsEmpty() {
        getView()?.showErrorOnUsernameField("Required Field")
    }

    override fun passwordIsEmpty() {
        getView()?.showErrorOnPasswordField("Required Field")
    }

    override fun showUserLoginError() {
        showError("Login Error")
    }

    override fun showUserSignUpError() {
        showError("Signup Error")
    }
}