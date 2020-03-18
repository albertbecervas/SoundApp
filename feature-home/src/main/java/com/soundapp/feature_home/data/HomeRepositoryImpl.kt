package com.soundapp.feature_home.data

import com.abecerra.base.data.BaseRepositoryImpl
import com.soundapp.feature_home.domain.repository.HomeRepository
import com.soundapp.feature_home.domain.repository.HomeRepositoryOutput
import com.soundapp.network.dto.ResponseDto
import com.soundapp.network.dto.SongDto
import com.soundapp.network.services.music.MusicService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeRepositoryImpl(private val musicService: MusicService) :
    BaseRepositoryImpl<HomeRepositoryOutput>(), HomeRepository {

    override fun getRockSongs() {
        musicService.searchSongs("rock").enqueue(object : Callback<ResponseDto<SongDto>> {
            override fun onResponse(
                call: Call<ResponseDto<SongDto>>,
                response: Response<ResponseDto<SongDto>>
            ) {
                output?.onRockSongsReceived(
                    SongDtoMapper.mapToSong(response.body()?.results ?: arrayListOf())
                )
            }

            override fun onFailure(call: Call<ResponseDto<SongDto>>, t: Throwable) {

            }
        })
    }
}