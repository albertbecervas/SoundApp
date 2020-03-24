package com.abecerra.soundapp.di.module.presentation

import android.content.Context
import android.net.Uri
import com.abecerra.soundapp.navigation.navigator.Navigator
import com.abecerra.soundapp.navigation.routers.SongPlayerActivityRouterImpl
import com.abecerra.soundapp.navigation.routers.SongPlayerRouterImpl
import com.abecerra.soundapp.scenes.player.presenter.SongPlayerActivityPresenter
import com.abecerra.soundapp.scenes.player.presenter.SongPlayerActivityPresenterImpl
import com.abecerra.soundapp.scenes.player.router.SongPlayerActivityRouter
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.source.ConcatenatingMediaSource
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.ui.PlayerNotificationManager
import com.google.android.exoplayer2.upstream.DataSource
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.google.android.exoplayer2.util.Util
import com.soundapp.database.dao.songs.SongsDao
import com.soundapp.feature_commons.presentation.model.SongViewModel
import com.soundapp.feature_player.R
import com.soundapp.feature_player.data.SongPlayerRepositoryImpl
import com.soundapp.feature_player.domain.interactor.SongPlayerInteractor
import com.soundapp.feature_player.domain.interactor.SongPlayerInteractorImpl
import com.soundapp.feature_player.domain.repository.SongPlayerRepository
import com.soundapp.feature_player.presentation.notification.SongPlayerNotificationAdapter
import com.soundapp.feature_player.presentation.notification.SongPlayerNotificationBuilder
import com.soundapp.feature_player.presentation.presenter.SongPlayerPresenter
import com.soundapp.feature_player.presentation.presenter.SongPlayerPresenterImpl
import com.soundapp.feature_player.presentation.router.SongPlayerRouter
import com.soundapp.feature_player.presentation.view.SongPlayerFragment
import dagger.Module
import dagger.Provides

@Module
class MediaPlayerModule(private val context: Context, private val songList: List<SongViewModel>) {

    @Provides
    fun provideContext(): Context = context

    @Provides
    fun provideDataSourceFactory(context: Context): DataSource.Factory {
        return DefaultDataSourceFactory(
            context, Util.getUserAgent(context, context.getString(R.string.app_name))
        )
    }

    @Provides
    fun provideMediaSources(dataSourceFactory: DataSource.Factory): Array<ProgressiveMediaSource> {

        return songList.map {
            ProgressiveMediaSource.Factory(dataSourceFactory)
                .setTag(it)
                .createMediaSource(Uri.parse(it.preview))
        }.toTypedArray()
    }

    @Provides
    fun provideConcatenatingMediaSource(progressiveMediaSource: Array<ProgressiveMediaSource>)
            : ConcatenatingMediaSource {
        return ConcatenatingMediaSource(*progressiveMediaSource)
    }

    @Provides
    fun provideSongPlayerNotificationAdapter(songPlayerRouter: SongPlayerRouter):
            SongPlayerNotificationAdapter {
        return SongPlayerNotificationAdapter(songPlayerRouter)
    }

    @Provides
    fun providePlayerNotificationManager(
        context: Context,
        songPlayerNotificationAdapter: SongPlayerNotificationAdapter
    ): PlayerNotificationManager {
        return SongPlayerNotificationBuilder(context, songPlayerNotificationAdapter)
            .createSongPlayerNotificationPlayer()
    }

    @Provides
    fun provideMediaPlayer(
        context: Context,
        songs: ConcatenatingMediaSource,
        songPlayerNotificationManager: PlayerNotificationManager
    ): SimpleExoPlayer {
        val exoPlayer = SimpleExoPlayer.Builder(context).build()
        exoPlayer.prepare(songs)
        songPlayerNotificationManager.setPlayer(exoPlayer)
        return exoPlayer
    }

    @Provides
    fun provideSongPlayerRepository(songsDao: SongsDao): SongPlayerRepository {
        return SongPlayerRepositoryImpl(songsDao)
    }

    @Provides
    fun provideSongPlayerInteractor(repository: SongPlayerRepository): SongPlayerInteractor {
        return SongPlayerInteractorImpl(repository)
    }

    @Provides
    fun provideSongPlayerRouter(context: Context, navigator: Navigator): SongPlayerRouter {
        return SongPlayerRouterImpl(navigator, context, songList)
    }

    @Provides
    fun provideSongPlayerPresenter(
        songPlayerRouter: SongPlayerRouter,
        simpleExoPlayer: SimpleExoPlayer,
        interactor: SongPlayerInteractor
    ): SongPlayerPresenter {
        return SongPlayerPresenterImpl(songPlayerRouter, simpleExoPlayer, interactor)
    }

    @Provides
    fun provideSongPlayerFragment(presenter: SongPlayerPresenter): SongPlayerFragment {
        val songPlayerFragment = SongPlayerFragment()
        songPlayerFragment.injectPresenter(presenter)
        return songPlayerFragment
    }

    @Provides
    fun provideSongPlayerActivityRouter(
        navigator: Navigator, songPlayerFragment: SongPlayerFragment
    ): SongPlayerActivityRouter {
        return SongPlayerActivityRouterImpl(navigator, songPlayerFragment)
    }

    @Provides
    fun provideSongPlayerActivityPresenter(songPlayerActivityRouter: SongPlayerActivityRouter): SongPlayerActivityPresenter {
        return SongPlayerActivityPresenterImpl(songPlayerActivityRouter)
    }
}