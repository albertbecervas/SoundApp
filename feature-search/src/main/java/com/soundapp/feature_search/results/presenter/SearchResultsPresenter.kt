package com.soundapp.feature_search.results.presenter

import com.abecerra.base.presentation.BasePresenter
import com.abecerra.components.search.SearchComponentOutput
import com.soundapp.feature_search.results.view.SearchResultsAdapter
import com.soundapp.feature_search.results.view.SearchResultsView

interface SearchResultsPresenter : BasePresenter<SearchResultsView>, SearchComponentOutput {

    fun getSearchResultsAdapter(): SearchResultsAdapter
}