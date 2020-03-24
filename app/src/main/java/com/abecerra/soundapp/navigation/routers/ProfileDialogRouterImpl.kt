package com.abecerra.soundapp.navigation.routers

import com.abecerra.soundapp.navigation.navigator.Navigator
import com.abecerra.soundapp.scenes.launcher.view.LauncherActivity
import com.soundapp.feature_profile.router.ProfileDialogRouter

class ProfileDialogRouterImpl(private val navigator: Navigator) : ProfileDialogRouter {
    override fun openGithubUrl(url: String) {
        navigator.openUrl(url)
    }

    override fun sendFeedbackIntent(email: String) {
        navigator.sendEmail(email)
    }

    override fun logout() {
        navigator.startActivityFinishingCurrent(LauncherActivity::class.java)
    }
}