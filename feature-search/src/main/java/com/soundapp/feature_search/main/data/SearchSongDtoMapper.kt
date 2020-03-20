package com.soundapp.feature_search.main.data

import com.soundapp.feature_search.main.domain.model.SearchSong
import com.soundapp.network.dto.SongDto
import com.soundapp.network.utils.toBoolean
import com.soundapp.network.utils.toDouble
import com.soundapp.network.utils.toInt
import com.soundapp.network.utils.toString

object SearchSongDtoMapper {

    fun mapToSong(from: List<SongDto>): List<SearchSong> {
        return from.map {
            mapToSong(
                it
            )
        }
    }

    private fun mapToSong(from: SongDto): SearchSong {
        return with(from) {
            SearchSong(
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
                artworkUrl100.toString(),
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
}