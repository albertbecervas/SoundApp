package com.abecerra.soundapp.di.module.domain

import com.abecerra.appresources.Translator
import com.soundapp.session.authentication.domain.interactor.SessionInteractor
import com.soundapp.session.authentication.domain.interactor.SessionInteractorImpl
import com.soundapp.session.authentication.domain.repository.SessionRepository
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.soundapp.feature_commons.domain.PlaylistInteractor
import com.soundapp.feature_commons.domain.PlaylistInteractorImpl
import com.soundapp.feature_home.domain.interactor.HomeInteractor
import com.soundapp.feature_home.domain.interactor.HomeInteractorImpl
import com.soundapp.feature_home.domain.repository.HomeRepository
import com.soundapp.feature_search.main.domain.interactor.SearchInteractorImpl
import com.soundapp.feature_search.main.domain.repository.SearchRepository
import com.soundapp.feature_search.main.domain.interactor.SearchInteractor
import dagger.Module
import dagger.Provides

@Module
class InteractorModule {

    @Provides
    fun provideSessionInteractor(
        sessionRepository: SessionRepository, googleSignInClient: GoogleSignInClient
    ): SessionInteractor {
        return SessionInteractorImpl(sessionRepository, googleSignInClient)
    }

    @Provides
    fun provideHomeInteractor(repository: HomeRepository, translator: Translator): HomeInteractor {
        return HomeInteractorImpl(repository, translator)
    }

    @Provides
    fun provideSearchInteractor(
        repository: SearchRepository, translator: Translator
    ): SearchInteractor {
        return SearchInteractorImpl(repository, translator)
    }

    @Provides
    fun providePlaylistInteractor(): PlaylistInteractor {
        return PlaylistInteractorImpl()
    }
}