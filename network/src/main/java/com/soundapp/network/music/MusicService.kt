package com.soundapp.network.music

import com.soundapp.network.SEARCH
import com.soundapp.network.TERM
import retrofit2.http.GET
import retrofit2.http.Query

interface MusicService {

    @GET(SEARCH)
    fun searchSongs(@Query(TERM) term: String)
}