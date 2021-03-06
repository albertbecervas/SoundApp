package com.soundapp.feature_commons.data

import com.soundapp.feature_commons.domain.model.Song
import com.soundapp.network.dto.SongDto
import com.soundapp.network.utils.*

object SongDtoMapper {

    fun mapToSong(from: List<SongDto>): List<Song> {
        return from.map {
            mapToSong(
                it
            )
        }
    }

    private fun mapToSong(from: SongDto): Song {
        return with(from) {
            Song(
                wrapperType.toString(),
                trackId.toString(),
                artistName.toString(),
                collectionName.toString(),
                trackName.toString(),
                collectionViewUrl.toString(),
                trackViewUrl.toString(),
                artistViewUrl.toString(),
                previewUrl.toString(),
                artworkUrl30.toString(),
                artworkUrl60.toString(),
                artworkUrl100.toString().changeImageSize(),
                collectionPrice.toDouble(),
                trackPrice.toDoubleOrZero(),
                releaseDate.toString(),
                collectionExplicitness.toString(),
                trackExplicitness.toString(),
                discCount.toInt(),
                trackCount.toInt(),
                discNumber.toInt(),
                trackNumber.toInt(),
                trackTimeMillis.toDouble(),
                country.toString(),
                currency.toString(),
                primaryGenreName.toString(),
                isStreamable.toBoolean()
            )
        }
    }

    private fun String.changeImageSize(): String {
        return this.replace("100x100bb", "500x500bb")
    }
}