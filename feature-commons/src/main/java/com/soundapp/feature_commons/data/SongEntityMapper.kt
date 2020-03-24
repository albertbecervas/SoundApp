package com.soundapp.feature_commons.data

import com.soundapp.database.entities.SavedSongEntity
import com.soundapp.feature_commons.domain.model.SavedSong

object SongEntityMapper {
    fun mapToSong(from: List<SavedSongEntity>): List<SavedSong> {
        return from.map { mapToSong(it) }
    }

    private fun mapToSong(from: SavedSongEntity): SavedSong {
        return with(from) {
            SavedSong(
                trackId,
                artistName,
                collectionName,
                trackName,
                trackViewUrl,
                previewUrl,
                artWorkUrl100,
                trackPrice,
                releaseDate,
                duration,
                primaryGenreName
            )
        }
    }

    fun mapToSongEntity(from: SavedSong): SavedSongEntity {
        return with(from) {
            SavedSongEntity(
                trackId,
                artistName,
                collectionName,
                trackName,
                trackViewUrl,
                previewUrl,
                artWorkUrl100,
                trackPrice,
                releaseDate,
                duration,
                primaryGenreName
            )
        }
    }
}