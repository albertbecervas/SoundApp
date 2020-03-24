package com.soundapp.feature_player.domain.interactor

import com.abecerra.base.domain.BaseInteractor
import com.soundapp.feature_commons.domain.model.SavedSong
import com.soundapp.feature_commons.presentation.model.SongViewModel

interface SongPlayerInteractor : BaseInteractor<SongPlayerInteractorOutput> {

    fun saveCurrentPlayingSong(savedSong: SavedSong)

    fun getShareText(songViewModel: SongViewModel): String
}