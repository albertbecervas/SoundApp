package com.soundapp.network.services.music

import com.soundapp.network.*
import com.soundapp.network.dto.ResponseDto
import com.soundapp.network.dto.SongDto
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MusicService {

    @GET(SEARCH)
    fun searchSongs(
        @Query(TERM) term: String,
        @Query(LIMIT) limit: Int = DEFAULT_LIMIT,
        @Query(MEDIA) media: String = MUSIC
    ): Call<ResponseDto<SongDto>>
}