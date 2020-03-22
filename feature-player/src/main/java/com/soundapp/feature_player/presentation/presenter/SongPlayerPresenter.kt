package com.soundapp.feature_player.presentation.presenter

import com.abecerra.base.presentation.BasePresenter
import com.google.android.exoplayer2.SimpleExoPlayer
import com.soundapp.feature_player.presentation.view.SongPlayerView

interface SongPlayerPresenter : BasePresenter<SongPlayerView> {

    fun initPlayer(): SimpleExoPlayer?
    fun onViewDestroyed()
}