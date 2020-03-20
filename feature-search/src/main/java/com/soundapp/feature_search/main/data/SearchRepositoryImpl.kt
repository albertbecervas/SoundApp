package com.soundapp.feature_search.main.data

import com.abecerra.base.data.BaseRepositoryImpl
import com.soundapp.feature_search.main.domain.repository.SearchRepository
import com.soundapp.feature_search.main.domain.repository.SearchRepositoryOutput
import com.soundapp.network.dto.ResponseDto
import com.soundapp.network.dto.SongDto
import com.soundapp.network.services.music.MusicService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchRepositoryImpl(private val musicService: MusicService) :
    BaseRepositoryImpl<SearchRepositoryOutput>(),
    SearchRepository {

    override fun doSearchCallWithTerm(term: String) {
        musicService.searchSongs(term).enqueue(object : Callback<ResponseDto<SongDto>> {
            override fun onResponse(
                call: Call<ResponseDto<SongDto>>,
                response: Response<ResponseDto<SongDto>>
            ) {
                output?.onSearchResponse(
                    SearchSongDtoMapper.mapToSong(response.body()?.results ?: arrayListOf())
                )
            }

            override fun onFailure(call: Call<ResponseDto<SongDto>>, t: Throwable) {

            }
        })
    }
}