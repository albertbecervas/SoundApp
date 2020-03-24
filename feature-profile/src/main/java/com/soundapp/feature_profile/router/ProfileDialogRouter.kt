package com.soundapp.feature_profile.router

interface ProfileDialogRouter {

    fun openGithubUrl(url: String)

    fun sendFeedbackIntent(email: String)

    fun logout()
}