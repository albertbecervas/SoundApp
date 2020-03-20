package com.soundapp.feature_search.main.presentation.presenter

import com.abecerra.base.presentation.BasePresenter
import com.abecerra.components.search.SearchComponentOutput
import com.soundapp.feature_search.main.presentation.view.SearchView
import com.soundapp.feature_search.results.SearchResultsFragment
import com.soundapp.feature_search.suggestions.SearchSuggestionsFragment

interface SearchPresenter : BasePresenter<SearchView>, SearchComponentOutput {

    fun setSearchResultsFragment(searchResultsFragment: SearchResultsFragment?)

    fun setSearchSuggestionsFragment(searchSuggestionsFragment: SearchSuggestionsFragment?)
}