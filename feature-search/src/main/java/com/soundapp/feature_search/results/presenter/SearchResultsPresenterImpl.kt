package com.soundapp.feature_search.results.presenter

import com.abecerra.base.presentation.BasePresenterImpl
import com.soundapp.feature_search.main.presentation.presenter.SearchPresenterListener
import com.soundapp.feature_search.main.domain.interactor.SearchInteractor
import com.soundapp.feature_search.main.domain.interactor.SearchInteractorOutput
import com.soundapp.feature_search.main.domain.model.SearchSong
import com.soundapp.feature_search.main.presentation.model.SearchSongViewModelMapper
import com.soundapp.feature_search.results.view.SearchResultsAdapter
import com.soundapp.feature_search.results.view.SearchResultsView

class SearchResultsPresenterImpl(
    private val searchPresenterListener: SearchPresenterListener,
    private val searchInteractor: SearchInteractor
) : BasePresenterImpl<SearchResultsView>(), SearchResultsPresenter, SearchInteractorOutput {

    private val adapter: SearchResultsAdapter = SearchResultsAdapter {
        searchPresenterListener.onSearchResultSelected(it)
    }

    init {
        searchInteractor.setInteractorOutput(this)
    }

    override fun getSearchResultsAdapter(): SearchResultsAdapter = adapter

    override fun onSearch(text: String) {
        searchInteractor.searchSongs(text)
        getView()?.showLoading()
    }

    override fun emptySearch() {
        adapter.clear()
        getView()?.hideLoading()
    }

    override fun onSearchSongsReceived(list: List<SearchSong>) {
        adapter.setItems(SearchSongViewModelMapper.mapSongs(list))
        getView()?.hideLoading()
    }
}