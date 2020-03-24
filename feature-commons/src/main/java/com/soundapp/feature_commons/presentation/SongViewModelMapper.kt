package com.soundapp.feature_commons.presentation

import com.abecerra.base.utils.formatDate
import com.abecerra.base.utils.formatTime
import com.soundapp.feature_commons.domain.model.SavedSong
import com.soundapp.feature_commons.domain.model.Song
import com.soundapp.feature_commons.presentation.model.SongViewModel

object SongViewModelMapper {

    fun mapSongs(from: List<Song>): List<SongViewModel> {
        return from.map { mapSong(it) }
    }

    private fun mapSong(from: Song): SongViewModel {
        return with(from) {
            SongViewModel(
                id = trackId,
                name = trackName,
                artist = artistName,
                album = collectionName,
                imageUrl = artWorkUrl100,
                duration = trackTimeMillis.formatTime(),
                date = releaseDate.formatDate(),
                price = trackPrice.toString().convertToDollars(),
                genre = primaryGenreName,
                preview = previewUrl,
                trackViewUrl = trackViewUrl
            )
        }
    }

    fun mapSavedSongs(from: List<SavedSong>): List<SongViewModel> {
        return from.map { mapSavedSong(it) }
    }

    private fun mapSavedSong(from: SavedSong): SongViewModel {
        return with(from) {
            SongViewModel(
                id = trackId,
                name = trackName,
                artist = artistName,
                album = collectionName,
                imageUrl = artWorkUrl100,
                duration = duration,
                date = releaseDate,
                price = trackPrice,
                genre = primaryGenreName,
                preview = previewUrl,
                trackViewUrl = trackViewUrl
            )
        }
    }

    fun mapSongViewModel(from: SongViewModel): SavedSong {
        return with(from) {
            SavedSong(
                trackId = id,
                artistName = artist,
                collectionName = album,
                trackName = name,
                trackViewUrl = trackViewUrl,
                previewUrl = preview,
                artWorkUrl100 = imageUrl,
                trackPrice = price,
                releaseDate = date,
                duration = duration,
                primaryGenreName = genre
            )
        }
    }

    private fun String.convertToDollars(): String {
        return "$this $"
    }
}