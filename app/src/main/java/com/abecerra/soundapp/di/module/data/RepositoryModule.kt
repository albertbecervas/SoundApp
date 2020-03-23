package com.abecerra.soundapp.di.module.data

import com.soundapp.database.dao.search.SearchesDao
import com.soundapp.database.dao.songs.SongsDao
import com.soundapp.feature_home.data.HomeRepositoryImpl
import com.soundapp.feature_home.domain.repository.HomeRepository
import com.soundapp.feature_search.main.data.SearchRepositoryImpl
import com.soundapp.feature_search.main.domain.repository.SearchRepository
import com.soundapp.network.services.authentication.AuthService
import com.soundapp.network.services.music.MusicService
import com.soundapp.session.authentication.data.SessionRepositoryImpl
import com.soundapp.session.authentication.domain.repository.SessionRepository
import com.soundapp.session.user.data.UserDataSource
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {

    @Provides
    fun provideSessionRepository(
        authService: AuthService, userDataSource: UserDataSource
    ): SessionRepository {
        return SessionRepositoryImpl(authService, userDataSource)
    }

    @Provides
    fun provideHomeRepository(musicService: MusicService, songsDao: SongsDao): HomeRepository {
        return HomeRepositoryImpl(musicService, songsDao)
    }

    @Provides
    fun provideSearchRepository(
        musicService: MusicService, searchesDao: SearchesDao
    ): SearchRepository {
        return SearchRepositoryImpl(musicService, searchesDao)
    }
}