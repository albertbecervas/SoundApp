package com.soundapp.feature_search.main.domain.interactor

import com.abecerra.base.domain.BaseInteractor
import com.soundapp.feature_search.main.domain.model.SearchSuggestion
import com.soundapp.feature_search.main.domain.model.SortOption

interface SearchInteractor : BaseInteractor<SearchInteractorOutput> {

    fun setSearchResultsOutput(resultsOutput: SearchInteractorResultOutput)

    fun setSearchSuggestionsOutput(suggestionsOutput: SearchInteractorSuggestionsOutput)

    fun searchSongs(term: String)

    fun getSortingOptions(): List<SortOption>

    fun getRecentSearches()

    fun removeRecentSearch(text: String)

    fun getSearchSuggestions(): List<SearchSuggestion>

    fun <T> preparePlayListFromItemSelected(item: T, list: ArrayList<T>): List<T>
}