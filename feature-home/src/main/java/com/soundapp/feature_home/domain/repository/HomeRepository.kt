package com.soundapp.feature_home.domain.repository

import com.abecerra.base.data.BaseRepository

interface HomeRepository : BaseRepository<HomeRepositoryOutput> {

    fun getRockSongs(limit: Int)
    fun getLatinoSongs(limit: Int)
    fun getPopSongs(limit: Int)
    fun getJazzSongs(limit: Int)

    fun getRecentlyPlayedSongs()
}