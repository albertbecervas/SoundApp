package com.soundapp.session.user

import com.soundapp.session.user.data.User

object UserSession {
    var isLogged: Boolean = false
    var user: User? = null
}