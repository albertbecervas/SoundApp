package com.soundapp.session.user.data

interface UserDataSource {

    fun isUserLogged(): Boolean

    fun setUserLogged()

    fun logOutUser()
}