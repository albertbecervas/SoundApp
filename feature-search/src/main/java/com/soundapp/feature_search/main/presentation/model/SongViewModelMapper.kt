package com.soundapp.feature_search.main.presentation.model

import com.soundapp.feature_search.main.domain.model.Song

object SongViewModelMapper {

    fun mapSongs(from: List<Song>): List<SongViewModel> {
        return from.map {
            mapSong(
                it
            )
        }
    }

    private fun mapSong(from: Song): SongViewModel {
        return with(from) {
            SongViewModel(
                trackName,
                trackTimeMillis.toString(),
                trackPrice.toString(),
                previewUrl
            )
        }
    }
}