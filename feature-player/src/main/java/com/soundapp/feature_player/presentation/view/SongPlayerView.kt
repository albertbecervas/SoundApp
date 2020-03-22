package com.soundapp.feature_player.presentation.view

import com.abecerra.base.presentation.BaseView
import com.soundapp.feature_commons.presentation.model.SongViewModel

interface SongPlayerView: BaseView {

    fun songDataUpdated(songViewModel: SongViewModel)
}