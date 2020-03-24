package com.abecerra.soundapp.scenes.player.presenter

import com.abecerra.base.presentation.BasePresenterImpl
import com.abecerra.soundapp.R
import com.abecerra.soundapp.scenes.player.router.SongPlayerActivityRouter
import com.abecerra.soundapp.scenes.player.view.SongPlayerActivityView

class SongPlayerActivityPresenterImpl(private val songPlayerActivityRouter: SongPlayerActivityRouter) :
    BasePresenterImpl<SongPlayerActivityView>(), SongPlayerActivityPresenter {

    override fun loadSongPlayerFragment() {
        songPlayerActivityRouter.loadSongPlayerFragment(R.id.fl_player)
    }
}