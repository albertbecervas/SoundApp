package com.soundapp.feature_search.results.presenter

import com.abecerra.base.presentation.BasePresenterImpl
import com.soundapp.feature_search.main.SearchPresenterListener
import com.soundapp.feature_search.main.presentation.model.SearchSongViewModel
import com.soundapp.feature_search.results.view.SearchResultsView
import com.soundapp.feature_search.results.view.SearchResultsAdapter

class SearchResultsPresenterImpl(private val searchPresenterListener: SearchPresenterListener) :
    BasePresenterImpl<SearchResultsView>(),
    SearchResultsPresenter {

    private val adapter: SearchResultsAdapter =
        SearchResultsAdapter {
            searchPresenterListener.onSearchResultSelected(it)
        }

    override fun getSearchResultsAdapter(): SearchResultsAdapter = adapter

    override fun setResults(list: List<SearchSongViewModel>) {
        adapter.setItems(list)
    }

    override fun clearResults() {
        adapter.clear()
    }
}