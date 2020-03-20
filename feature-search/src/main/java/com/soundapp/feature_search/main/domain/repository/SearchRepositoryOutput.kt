package com.soundapp.feature_search.main.domain.repository

import com.soundapp.feature_search.main.domain.model.SearchSong

interface SearchRepositoryOutput {

    fun onSearchResponse(list: List<SearchSong>)
}