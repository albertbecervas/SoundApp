package com.soundapp.feature_search.main.domain.repository

import com.abecerra.base.data.BaseRepository

interface SearchRepository : BaseRepository<SearchRepositoryOutput> {

    fun getRockSongs()
}