package com.soundapp.feature_search.main.presentation.model

import com.soundapp.feature_search.main.domain.model.SearchSong

object SearchSongViewModelMapper {

    fun mapSongs(from: List<SearchSong>): List<SearchSongViewModel> {
        return from.map {
            mapSong(
                it
            )
        }
    }

    private fun mapSong(from: SearchSong): SearchSongViewModel {
        return with(from) {
            SearchSongViewModel(
                trackId,
                trackName,
                artistName,
                trackTimeMillis.toString(),
                trackPrice.toString(),
                previewUrl
            )
        }
    }
}