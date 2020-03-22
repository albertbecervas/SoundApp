package com.soundapp.feature_player.presentation.presenter

import com.abecerra.base.presentation.BasePresenterImpl
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.audio.AudioListener
import com.soundapp.feature_commons.presentation.model.SongViewModel
import com.soundapp.feature_player.presentation.view.SongPlayerView

class SongPlayerPresenterImpl(
    private val exoPlayer: SimpleExoPlayer
) : BasePresenterImpl<SongPlayerView>(), SongPlayerPresenter {

    override fun initPlayer(): SimpleExoPlayer? {
        exoPlayer.addListener(object : Player.EventListener {
            override fun onPositionDiscontinuity(reason: Int) {
                super.onPositionDiscontinuity(reason)
                if (reason == Player.DISCONTINUITY_REASON_SEEK_ADJUSTMENT ||
                    reason == Player.DISCONTINUITY_REASON_PERIOD_TRANSITION) {
                    updateSongData()
                }
            }
        })
        return exoPlayer
    }

    override fun onViewDestroyed() {
        exoPlayer.release()
    }

    private fun updateSongData() {
        (exoPlayer.currentTag as? SongViewModel)?.let {
            getView()?.songDataUpdated(it)
        }
    }
}