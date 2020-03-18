package com.soundapp.session.authentication.domain.repository

import com.abecerra.base.data.BaseRepository
import com.soundapp.session.authentication.domain.model.UserForm

interface SessionRepository : BaseRepository<SessionRepositoryOutput> {

    fun doLogin(user: UserForm)

    fun doSignUpWithEmailAndPassword(user: UserForm)

    fun saveLoggedUser(userId: String)

    fun doLogout()

    fun checkIfUserIsLoggedIn(): Boolean
}