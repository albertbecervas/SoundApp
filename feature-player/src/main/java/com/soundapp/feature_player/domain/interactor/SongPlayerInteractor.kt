package com.soundapp.feature_player.domain.interactor

import com.abecerra.base.domain.BaseInteractor
import com.soundapp.feature_commons.domain.model.SavedSong

interface SongPlayerInteractor : BaseInteractor<SongPlayerInteractorOutput> {

    fun saveCurrentPlayingSong(savedSong: SavedSong)
}