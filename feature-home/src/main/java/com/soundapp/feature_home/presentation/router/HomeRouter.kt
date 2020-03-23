package com.soundapp.feature_home.presentation.router

import com.soundapp.feature_commons.presentation.model.SongViewModel

interface HomeRouter {

    fun onSongSelected(songs: Array<SongViewModel>)
}