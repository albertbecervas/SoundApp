package com.soundapp.feature_search.results.presenter

import com.abecerra.base.presentation.BasePresenterImpl
import com.abecerra.components.filter.SortComponent
import com.soundapp.feature_commons.domain.PlaylistInteractor
import com.soundapp.feature_commons.domain.model.Song
import com.soundapp.feature_commons.presentation.SongViewModelMapper
import com.soundapp.feature_commons.presentation.model.SongViewModel
import com.soundapp.feature_search.main.domain.interactor.SearchInteractor
import com.soundapp.feature_search.main.domain.interactor.SearchInteractorResultOutput
import com.soundapp.feature_search.main.domain.model.SortOption.Companion.DURATION
import com.soundapp.feature_search.main.domain.model.SortOption.Companion.GENRE
import com.soundapp.feature_search.main.domain.model.SortOption.Companion.PRICE
import com.soundapp.feature_search.main.presentation.model.SortViewModelMapper
import com.soundapp.feature_search.main.presentation.presenter.SearchPresenterListener
import com.soundapp.feature_search.results.view.SearchResultsAdapter
import com.soundapp.feature_search.results.view.SearchResultsView

class SearchResultsPresenterImpl(
    private val searchPresenterListener: SearchPresenterListener,
    private val searchInteractor: SearchInteractor,
    private val playlistInteractor: PlaylistInteractor
) : BasePresenterImpl<SearchResultsView>(), SearchResultsPresenter, SearchInteractorResultOutput {

    private val adapter: SearchResultsAdapter = SearchResultsAdapter {
        handleAdapterItemSelected(it)
    }

    init {
        searchInteractor.setSearchResultsOutput(this)
    }

    override fun getSearchResultsAdapter(): SearchResultsAdapter = adapter

    override fun onSearch(text: String) {
        getView()?.showLoading()
        searchInteractor.searchSongs(text)
        clearResults()
    }

    override fun emptySearch() {
        getView()?.hideLoading()
        clearResults()
    }

    override fun bindSortComponent(sortComponent: SortComponent) {
        sortComponent.setSortingOptions(
            SortViewModelMapper.map(searchInteractor.getSortingOptions()), this
        )
    }

    override fun onSearchSongsReceived(list: List<Song>) {
        adapter.setItems(SongViewModelMapper.mapSongs(list))
        searchPresenterListener.onSearchResultsReceived()
        getView()?.hideLoading()
        getView()?.hideEmptyResults()
        getView()?.showSortComponent()
    }

    override fun onNoResultsFound() {
        getView()?.run {
            hideLoading()
            showEmptyResults()
            hideSortComponent()
        }
    }

    override fun onSortSelected(id: Int) {
        adapter.setItems(sortAdapterItemsById(id))
    }

    private fun clearResults() {
        adapter.clear()
        getView()?.hideEmptyResults()
        getView()?.hideSortComponent()
    }

    private fun sortAdapterItemsById(id: Int): List<SongViewModel> {
        return when (id) {
            PRICE -> adapter.getItems().sortedBy { it.price }
            DURATION -> adapter.getItems().sortedBy { it.duration }
            GENRE -> adapter.getItems().sortedBy { it.genre }
            else -> adapter.getItems()
        }
    }

    private fun handleAdapterItemSelected(songViewModel: SongViewModel) {
        val songsList: List<SongViewModel> = playlistInteractor.preparePlayListFromItemSelected(
            songViewModel,
            adapter.getItems()
        )
        searchPresenterListener.onSearchResultSelected(songsList)
    }
}