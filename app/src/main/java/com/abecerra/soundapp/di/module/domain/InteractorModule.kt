package com.abecerra.soundapp.di.module.domain

import com.soundapp.session.authentication.domain.interactor.SessionInteractor
import com.soundapp.session.authentication.domain.interactor.SessionInteractorImpl
import com.soundapp.session.authentication.domain.repository.SessionRepository
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.soundapp.feature_home.domain.interactor.HomeInteractor
import com.soundapp.feature_home.domain.interactor.HomeInteractorImpl
import com.soundapp.feature_home.domain.repository.HomeRepository
import dagger.Module
import dagger.Provides

@Module
class InteractorModule {

    @Provides
    fun provideSessionInteractor(
        sessionRepository: SessionRepository,
        googleSignInClient: GoogleSignInClient
    ): SessionInteractor {
        return SessionInteractorImpl(sessionRepository, googleSignInClient)
    }

    @Provides
    fun provideHomeInteractor(repository: HomeRepository): HomeInteractor {
        return HomeInteractorImpl(repository)
    }
}