package com.soundapp.feature_search.suggestions.presenter

import com.abecerra.base.presentation.BasePresenter
import com.soundapp.feature_search.suggestions.view.RecentSearchesAdapter
import com.soundapp.feature_search.suggestions.view.SearchSuggestionsAdapter
import com.soundapp.feature_search.suggestions.view.SearchSuggestionsView

interface SearchSuggestionsPresenter : BasePresenter<SearchSuggestionsView> {

    fun getSearchSuggestionsAdapter(): SearchSuggestionsAdapter

    fun getRecentSearchesAdapter(): RecentSearchesAdapter

    fun loadSearchSuggestions()

    fun loadRecentSearches()
}