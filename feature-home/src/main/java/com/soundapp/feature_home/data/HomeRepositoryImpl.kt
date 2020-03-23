package com.soundapp.feature_home.data

import com.abecerra.base.data.BaseRepositoryImpl
import com.soundapp.database.dao.songs.SongsDao
import com.soundapp.feature_commons.data.SongDtoMapper
import com.soundapp.feature_commons.data.SongEntityMapper
import com.soundapp.feature_commons.domain.model.Song
import com.soundapp.feature_home.domain.repository.HomeRepository
import com.soundapp.feature_home.domain.repository.HomeRepositoryOutput
import com.soundapp.network.dto.ResponseDto
import com.soundapp.network.dto.SongDto
import com.soundapp.network.services.music.MusicService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeRepositoryImpl(private val musicService: MusicService, private val songsDao: SongsDao) :
    BaseRepositoryImpl<HomeRepositoryOutput>(), HomeRepository {

    override fun getRockSongs(limit: Int) {
        makeSearchApiCall(ROCK_TERM, limit) {
            output?.onRockSongsReceived(it)
        }
    }

    override fun getLatinoSongs(limit: Int) {
        makeSearchApiCall(LATINO_TERM, limit) {
            output?.onLatinoSongsReceived(it)
        }
    }

    override fun getPopSongs(limit: Int) {
        makeSearchApiCall(POP_TERM, limit) {
            output?.onPopSongsReceived(it)
        }
    }

    override fun getJazzSongs(limit: Int) {
        makeSearchApiCall(JAZZ_TERM, limit) {
            output?.onJazzSongsReceived(it)
        }
    }

    private fun makeSearchApiCall(
        term: String, limit: Int, onResponse: (list: List<Song>) -> Unit
    ) {
        musicService.searchSongs(term, limit).enqueue(object : Callback<ResponseDto<SongDto>> {
            override fun onResponse(
                call: Call<ResponseDto<SongDto>>,
                response: Response<ResponseDto<SongDto>>
            ) {
                onResponse(SongDtoMapper.mapToSong(response.body()?.results ?: arrayListOf()))
            }

            override fun onFailure(call: Call<ResponseDto<SongDto>>, t: Throwable) {
                onResponse(arrayListOf())
            }
        })
    }

    override fun getRecentlyPlayedSongs() {
        songsDao.getRecentlyPlayed {
            output?.onRecentlyPlayedSongsFound(SongEntityMapper.mapToSong(it))
        }
    }

    companion object {
        const val ROCK_TERM = "rock"
        const val LATINO_TERM = "latino"
        const val POP_TERM = "pop"
        const val JAZZ_TERM = "jazz"
    }
}