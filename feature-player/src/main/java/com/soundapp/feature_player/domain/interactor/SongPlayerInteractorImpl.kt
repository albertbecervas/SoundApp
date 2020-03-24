package com.soundapp.feature_player.domain.interactor

import com.abecerra.base.domain.BaseInteractorImpl
import com.soundapp.feature_commons.domain.model.SavedSong
import com.soundapp.feature_commons.presentation.model.SongViewModel
import com.soundapp.feature_player.domain.repository.SongPlayerRepository

class SongPlayerInteractorImpl(private val repository: SongPlayerRepository) :
    BaseInteractorImpl<SongPlayerInteractorOutput>(),
    SongPlayerInteractor {
    override fun saveCurrentPlayingSong(savedSong: SavedSong) {
        repository.saveSongPlayed(savedSong)
    }

    override fun getShareText(songViewModel: SongViewModel): String =
        "${songViewModel.name}: ${songViewModel.preview}"
}