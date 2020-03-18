package com.soundapp.network.services.music

import com.soundapp.network.SEARCH
import com.soundapp.network.TERM
import com.soundapp.network.dto.ResponseDto
import com.soundapp.network.dto.SongDto
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MusicService {

    @GET(SEARCH)
    fun searchSongs(@Query(TERM) term: String): Call<ResponseDto<SongDto>>
}