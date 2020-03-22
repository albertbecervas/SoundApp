package com.soundapp.feature_commons.presentation

import com.soundapp.feature_commons.presentation.model.SongViewModel

object SongViewModelMapper {

    fun mapSongs(from: List<com.soundapp.feature_commons.domain.model.Song>): List<SongViewModel> {
        return from.map { mapSong(it) }
    }

    private fun mapSong(from: com.soundapp.feature_commons.domain.model.Song): SongViewModel {
        return with(from) {
            SongViewModel(
                trackName,
                artistName,
                artWorkUrl100,
                trackTimeMillis.toString(),
                trackPrice.toString(),
                previewUrl
            )
        }
    }
}