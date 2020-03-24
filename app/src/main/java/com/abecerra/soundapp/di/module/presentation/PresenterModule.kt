package com.abecerra.soundapp.di.module.presentation

import com.abecerra.appresources.Translator
import com.abecerra.soundapp.scenes.launcher.presenter.LauncherPresenter
import com.abecerra.soundapp.scenes.launcher.presenter.LauncherPresenterImpl
import com.abecerra.soundapp.scenes.launcher.router.LauncherRouter
import com.abecerra.soundapp.scenes.main.presenter.MainPresenter
import com.abecerra.soundapp.scenes.main.presenter.MainPresenterImpl
import com.abecerra.soundapp.scenes.main.router.MainRouter
import com.soundapp.feature_commons.domain.PlaylistInteractor
import com.soundapp.feature_home.domain.interactor.HomeInteractor
import com.soundapp.feature_home.presentation.presenter.HomePresenter
import com.soundapp.feature_home.presentation.presenter.HomePresenterImpl
import com.soundapp.feature_home.presentation.router.HomeRouter
import com.soundapp.feature_profile.presenter.ProfileDialogPresenter
import com.soundapp.feature_profile.presenter.ProfileDialogPresenterImpl
import com.soundapp.feature_profile.router.ProfileDialogRouter
import com.soundapp.feature_search.main.domain.interactor.SearchInteractor
import com.soundapp.feature_search.main.presentation.presenter.SearchPresenter
import com.soundapp.feature_search.main.presentation.presenter.SearchPresenterImpl
import com.soundapp.feature_search.main.presentation.router.SearchRouter
import com.soundapp.session.authentication.domain.interactor.SessionInteractor
import com.soundapp.session.login.presenter.LoginPresenter
import com.soundapp.session.login.presenter.LoginPresenterImpl
import com.soundapp.session.login.router.LoginRouter
import com.soundapp.session.signup.presenter.SignUpPresenter
import com.soundapp.session.signup.presenter.SignUpPresenterImpl
import com.soundapp.session.signup.router.SignUpRouter
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
    fun provideSignUpPresenter(
        router: SignUpRouter, interactor: SessionInteractor
    ): SignUpPresenter {
        return SignUpPresenterImpl(router, interactor)
    }

    @Provides
    fun provideHomePresenter(
        router: HomeRouter, interactor: HomeInteractor, playlistInteractor: PlaylistInteractor
    ): HomePresenter {
        return HomePresenterImpl(router, interactor, playlistInteractor)
    }

    @Provides
    fun provideSearchPresenter(
        router: SearchRouter, interactor: SearchInteractor, playlistInteractor: PlaylistInteractor
    ): SearchPresenter {
        return SearchPresenterImpl(router, interactor, playlistInteractor)
    }

    @Provides
    fun provideProfilePresenter(
        router: ProfileDialogRouter, interactor: SessionInteractor
    ): ProfileDialogPresenter {
        return ProfileDialogPresenterImpl(router, interactor)
    }
}