package com.soundapp.feature_search.main.domain.repository

import com.soundapp.feature_commons.domain.model.Song
import com.soundapp.feature_search.main.domain.model.RecentSearch

interface SearchRepositoryOutput {

    fun onSearchResponse(list: List<Song>)

    fun onRecentSearchesResponse(list: List<RecentSearch>)
}