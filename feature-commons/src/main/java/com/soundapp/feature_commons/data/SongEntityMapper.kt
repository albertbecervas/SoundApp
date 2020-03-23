package com.soundapp.feature_commons.data

import com.soundapp.database.entities.SongEntity
import com.soundapp.feature_commons.domain.model.Song

object SongEntityMapper {
    fun mapToSong(from: List<SongEntity>): List<Song> {
        return from.map {
            mapToSong(
                it
            )
        }
    }

    private fun mapToSong(from: SongEntity): Song {
        return with(from) {
            Song(
                wrapperType,
                trackId,
                artistName,
                collectionName,
                trackName,
                collectionViewUrl,
                trackViewUrl,
                artistViewUrl,
                previewUrl,
                artworkUrl30,
                artworkUrl60,
                artworkUrl100,
                collectionPrice,
                trackPrice,
                releaseDate,
                collectionExplicitness,
                trackExplicitness,
                discCount,
                trackCount,
                discNumber,
                trackNumber,
                trackTimeMillis,
                country,
                currency,
                primaryGenreName,
                isStreamable
            )
        }
    }
}