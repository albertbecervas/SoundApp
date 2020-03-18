package com.abecerra.soundapp.di.module.presentation

import com.abecerra.appresources.Translator
import com.abecerra.soundapp.scenes.launcher.presenter.LauncherPresenter
import com.abecerra.soundapp.scenes.launcher.presenter.LauncherPresenterImpl
import com.abecerra.soundapp.scenes.launcher.router.LauncherRouter
import com.abecerra.soundapp.scenes.main.presenter.MainPresenter
import com.abecerra.soundapp.scenes.main.presenter.MainPresenterImpl
import com.abecerra.soundapp.scenes.main.router.MainRouter
import com.soundapp.feature_home.domain.interactor.HomeInteractor
import com.soundapp.feature_home.presentation.presenter.HomePresenter
import com.soundapp.feature_home.presentation.presenter.HomePresenterImpl
import com.soundapp.feature_home.presentation.router.HomeRouter
import com.soundapp.session.authentication.domain.interactor.SessionInteractor
import com.soundapp.session.login.presenter.LoginPresenter
import com.soundapp.session.login.presenter.LoginPresenterImpl
import com.soundapp.session.login.router.LoginRouter
import dagger.Module
import dagger.Provides

@Module
class PresenterModule {

    @Provides
    fun provideLauncherPresenter(
        router: LauncherRouter,
        sessionInteractor: SessionInteractor
    ): LauncherPresenter {
        return LauncherPresenterImpl(router, sessionInteractor)
    }

    @Provides
    fun provideMainPresenter(router: MainRouter, translator: Translator): MainPresenter {
        return MainPresenterImpl(router, translator)
    }

    @Provides
    fun provideLoginPresenter(
        router: LoginRouter, interactor: SessionInteractor
    ): LoginPresenter {
        return LoginPresenterImpl(router, interactor)
    }

    @Provides
    fun provideHomePresenter(router: HomeRouter, interactor: HomeInteractor): HomePresenter {
        return HomePresenterImpl(router, interactor)
    }
}