package com.soundapp.feature_commons.presentation

import com.abecerra.base.utils.formatDate
import com.abecerra.base.utils.formatTime
import com.soundapp.feature_commons.domain.model.Song
import com.soundapp.feature_commons.presentation.model.SongViewModel

object SongViewModelMapper {

    fun mapSongs(from: List<Song>): List<SongViewModel> {
        return from.map { mapSong(it) }
    }

    private fun mapSong(from: Song): SongViewModel {
        return with(from) {
            SongViewModel(
                trackName,
                artistName,
                collectionName,
                artWorkUrl100,
                trackTimeMillis.formatTime(),
                releaseDate.formatDate(),
                trackPrice.toString().convertToDollars(),
                primaryGenreName,
                previewUrl
            )
        }
    }

    private fun String.convertToDollars(): String {
        return "$this $"
    }
}