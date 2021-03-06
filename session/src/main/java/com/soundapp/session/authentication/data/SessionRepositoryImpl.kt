package com.soundapp.session.authentication.data

import com.abecerra.base.data.BaseRepositoryImpl
import com.soundapp.network.services.authentication.AuthService
import com.soundapp.session.authentication.domain.model.UserForm
import com.soundapp.session.authentication.domain.repository.SessionRepository
import com.soundapp.session.authentication.domain.repository.SessionRepositoryOutput
import com.soundapp.session.user.data.UserDataSource
import io.realm.Realm

class SessionRepositoryImpl(
    private val authService: AuthService,
    private val userDataSource: UserDataSource
) : BaseRepositoryImpl<SessionRepositoryOutput>(), SessionRepository {

    override fun checkIfUserIsLoggedIn(): Boolean {
        return userDataSource.isUserLogged()
    }

    override fun doLogin(user: UserForm) {
        authService.login(user.username, user.password, {
            userDataSource.setUserLogged()
            saveLoggedUser(it)
            output?.onSuccessfulSignIn()
        }, {
            output?.onErrorSigningIn()
        })
    }

    override fun doSignUpWithEmailAndPassword(user: UserForm) {
        authService.signUpWithEmailAndPassword(user.username, user.password, {
            userDataSource.setUserLogged()
            saveLoggedUser(it)
            output?.onSuccessfulSignUp()
        }, {
            output?.onErrorSigningUp()
        })
    }

    override fun saveLoggedUser(userId: String) {
        authService.createUserEntry(userId)
        userDataSource.setUserLogged()
    }

    override fun doLogout() {
        authService.logout()
        userDataSource.logOutUser()
        Realm.getDefaultInstance().executeTransactionAsync {
            it.deleteAll()
        }
    }
}