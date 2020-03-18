package com.soundapp.session.authentication.domain.repository

interface SessionRepositoryOutput {

    fun onSuccessfulSignIn()

    fun onSuccessfulSignUp()

    fun onErrorSigningIn()

    fun onErrorSigningUp()
}