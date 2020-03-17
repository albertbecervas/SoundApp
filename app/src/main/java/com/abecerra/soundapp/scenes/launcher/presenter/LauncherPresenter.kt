package com.abecerra.soundapp.scenes.launcher.presenter

import com.abecerra.base.presentation.BasePresenter
import com.abecerra.soundapp.scenes.launcher.view.LauncherView

interface LauncherPresenter : BasePresenter<LauncherView> {

    fun decideNavigation()
}