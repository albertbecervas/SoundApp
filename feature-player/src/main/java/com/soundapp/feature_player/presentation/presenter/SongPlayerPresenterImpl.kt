package com.soundapp.feature_player.presentation.presenter

import com.abecerra.base.presentation.BasePresenterImpl
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.analytics.AnalyticsListener
import com.soundapp.feature_commons.presentation.SongViewModelMapper
import com.soundapp.feature_commons.presentation.model.SongViewModel
import com.soundapp.feature_player.domain.interactor.SongPlayerInteractor
import com.soundapp.feature_player.presentation.router.SongPlayerRouter
import com.soundapp.feature_player.presentation.view.SongPlayerView

class SongPlayerPresenterImpl(
    private val router: SongPlayerRouter, private val exoPlayer: SimpleExoPlayer,
    private val interactor: SongPlayerInteractor
) : BasePresenterImpl<SongPlayerView>(), SongPlayerPresenter {

    override fun initPlayer(): SimpleExoPlayer? {
        setListenerForPlayerReady()
        setListenerForSongChanged()
        return exoPlayer
    }

    override fun onShareClicked() {
        getCurrentSong()?.let { router.shareSong(interactor.getShareText(it)) }
    }

    override fun onViewDestroyed() {
        exoPlayer.release()
    }

    private fun setListenerForSongChanged() {
        exoPlayer.addListener(object : Player.EventListener {
            override fun onPositionDiscontinuity(reason: Int) {
                super.onPositionDiscontinuity(reason)
                if (reason == Player.DISCONTINUITY_REASON_SEEK_ADJUSTMENT ||
                    reason == Player.DISCONTINUITY_REASON_PERIOD_TRANSITION
                ) {
                    updateSongData()
                }
            }
        })
    }

    private fun setListenerForPlayerReady() {
        exoPlayer.addAnalyticsListener(object : AnalyticsListener {
            override fun onAudioSessionId(
                eventTime: AnalyticsListener.EventTime, audioSessionId: Int
            ) {
                super.onAudioSessionId(eventTime, audioSessionId)
                updateSongData()
            }
        })
    }

    private fun updateSongData() {
        getCurrentSong()?.let {
            getView()?.songDataUpdated(it)
            interactor.saveCurrentPlayingSong(SongViewModelMapper.mapSongViewModel(it))
        }
    }

    private fun getCurrentSong(): SongViewModel? = exoPlayer.currentTag as? SongViewModel
}