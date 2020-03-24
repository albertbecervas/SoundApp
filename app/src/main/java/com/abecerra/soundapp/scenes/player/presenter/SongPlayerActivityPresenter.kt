package com.abecerra.soundapp.scenes.player.presenter

import com.abecerra.base.presentation.BasePresenter
import com.abecerra.soundapp.scenes.player.view.SongPlayerActivityView

interface SongPlayerActivityPresenter : BasePresenter<SongPlayerActivityView> {

    fun loadSongPlayerFragment()
}