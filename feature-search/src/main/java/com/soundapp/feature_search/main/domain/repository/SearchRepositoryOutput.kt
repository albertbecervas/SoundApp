package com.soundapp.feature_search.main.domain.repository

import com.soundapp.feature_commons.domain.model.Song

interface SearchRepositoryOutput {

    fun onSearchResponse(list: List<Song>)
}