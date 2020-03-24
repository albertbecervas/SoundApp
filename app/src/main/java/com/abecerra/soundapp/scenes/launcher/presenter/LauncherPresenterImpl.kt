package com.abecerra.soundapp.scenes.launcher.presenter

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
            router.navigateToHome()
        } else {
            router.showLogin()
        }
    }
}