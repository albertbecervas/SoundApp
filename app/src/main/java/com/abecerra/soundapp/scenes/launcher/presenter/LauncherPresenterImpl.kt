package com.abecerra.soundapp.scenes.launcher.presenter

import android.os.Handler
import com.abecerra.base.presentation.BasePresenterImpl
import com.abecerra.soundapp.scenes.launcher.router.LauncherRouter
import com.abecerra.soundapp.scenes.launcher.view.LauncherView
import com.soundapp.session.authentication.domain.interactor.SessionInteractor

class LauncherPresenterImpl(
    private val router: LauncherRouter,
    private val sessionInteractor: SessionInteractor
) : BasePresenterImpl<LauncherView>(), LauncherPresenter {
    override fun decideNavigation() {
        if (sessionInteractor.isUserLoggedIn()) {
            Handler().postDelayed({
                router.navigateToHome()
            }, 1000)
        } else {
            router.showLogin()
        }
    }
}