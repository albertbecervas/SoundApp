package com.soundapp.feature_commons.data

import com.soundapp.network.dto.SongDto
import com.soundapp.network.utils.toBoolean
import com.soundapp.network.utils.toDouble
import com.soundapp.network.utils.toInt
import com.soundapp.network.utils.toString

object SongDtoMapper {

    fun mapToSong(from: List<SongDto>): List<com.soundapp.feature_commons.domain.model.Song> {
        return from.map {
            mapToSong(
                it
            )
        }
    }

    private fun mapToSong(from: SongDto): com.soundapp.feature_commons.domain.model.Song {
        return with(from) {
            com.soundapp.feature_commons.domain.model.Song(
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
                trackPrice.toDouble(),
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