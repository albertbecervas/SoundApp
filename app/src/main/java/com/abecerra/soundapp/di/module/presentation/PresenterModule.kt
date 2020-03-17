package com.abecerra.soundapp.di.module.presentation

import com.abecerra.soundapp.scenes.launcher.presenter.LauncherPresenter
import com.abecerra.soundapp.scenes.launcher.presenter.LauncherPresenterImpl
import com.abecerra.soundapp.scenes.launcher.router.LauncherRouter
import com.abecerra.soundapp.scenes.main.presenter.MainPresenter
import com.abecerra.soundapp.scenes.main.presenter.MainPresenterImpl
import com.abecerra.soundapp.scenes.main.router.MainRouter
import com.diet.session.authentication.domain.interactor.SessionInteractor
import com.diet.session.login.presenter.LoginPresenter
import com.diet.session.login.presenter.LoginPresenterImpl
import com.diet.session.login.router.LoginRouter
import dagger.Module
import dagger.Provides

@Module
open class PresenterModule {

    @Provides
    fun provideLauncherPresenter(
        router: LauncherRouter,
        sessionInteractor: SessionInteractor
    ): LauncherPresenter {
        return LauncherPresenterImpl(router, sessionInteractor)
    }

    @Provides
    fun provideMainPresenter(router: MainRouter): MainPresenter {
        return MainPresenterImpl(router)
    }

    @Provides
    open fun provideLoginPresenter(
        router: LoginRouter, interactor: SessionInteractor
    ): LoginPresenter {
        return LoginPresenterImpl(router, interactor)
    }
}