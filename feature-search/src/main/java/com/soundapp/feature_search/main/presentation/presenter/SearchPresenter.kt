package com.soundapp.feature_search.main.presentation.presenter

import com.abecerra.base.presentation.BasePresenter
import com.abecerra.components.search.SearchComponentOutput
import com.soundapp.feature_search.main.presentation.view.SearchView
import com.soundapp.feature_search.results.view.SearchResultsFragment
import com.soundapp.feature_search.suggestions.view.SearchSuggestionsFragment

interface SearchPresenter : BasePresenter<SearchView>, SearchComponentOutput {

    fun getSearchResultsFragment(): SearchResultsFragment

    fun getSearchSuggestionsFragment(): SearchSuggestionsFragment
}