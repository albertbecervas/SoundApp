package com.soundapp.feature_search.main.domain.interactor

import com.soundapp.feature_search.main.domain.model.RecentSearch

interface SearchInteractorSuggestionsOutput {

    fun onRecentSearchesFound(list: List<RecentSearch>)

    fun onEmptyRecentSearches()
}