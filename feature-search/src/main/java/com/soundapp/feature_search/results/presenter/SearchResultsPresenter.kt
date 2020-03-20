package com.soundapp.feature_search.results.presenter

import com.abecerra.base.presentation.BasePresenter
import com.soundapp.feature_search.main.presentation.model.SearchSongViewModel
import com.soundapp.feature_search.results.view.SearchResultsView
import com.soundapp.feature_search.results.view.SearchResultsAdapter

interface SearchResultsPresenter : BasePresenter<SearchResultsView> {

    fun getSearchResultsAdapter(): SearchResultsAdapter

    fun setResults(list: List<SearchSongViewModel>)

    fun clearResults()
}