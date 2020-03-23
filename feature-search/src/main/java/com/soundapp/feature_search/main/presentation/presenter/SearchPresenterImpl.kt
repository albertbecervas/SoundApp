package com.soundapp.feature_search.main.presentation.presenter

import com.abecerra.base.presentation.BasePresenterImpl
import com.abecerra.components.search.SearchComponent
import com.soundapp.feature_commons.domain.PlaylistInteractor
import com.soundapp.feature_commons.presentation.model.SongViewModel
import com.soundapp.feature_search.SearchConfigurator
import com.soundapp.feature_search.main.domain.interactor.SearchInteractor
import com.soundapp.feature_search.main.presentation.router.SearchRouter
import com.soundapp.feature_search.main.presentation.view.SearchView
import com.soundapp.feature_search.results.presenter.SearchResultsPresenter
import com.soundapp.feature_search.results.view.SearchResultsFragment
import com.soundapp.feature_search.suggestions.presenter.SearchSuggestionsPresenter
import com.soundapp.feature_search.suggestions.view.SearchSuggestionsFragment

class SearchPresenterImpl(
    private val router: SearchRouter,
    private val searchInteractor: SearchInteractor,
    playlistInteractor: PlaylistInteractor
) : BasePresenterImpl<SearchView>(), SearchPresenter, SearchPresenterListener {

    private val searchResultsPresenter: SearchResultsPresenter =
        SearchConfigurator.configureSearchResultsPresenter(
            this, searchInteractor, playlistInteractor
        )

    private val searchSuggestionsPresenter: SearchSuggestionsPresenter =
        SearchConfigurator.configureSearchSuggestionsPresenter(this, searchInteractor)

    override fun getSearchResultsFragment(): SearchResultsFragment {
        val fragment = SearchResultsFragment()
        fragment.injectPresenter(searchResultsPresenter)
        return fragment
    }

    override fun getSearchSuggestionsFragment(): SearchSuggestionsFragment {
        val fragment = SearchSuggestionsFragment()
        fragment.injectPresenter(searchSuggestionsPresenter)
        return fragment
    }

    override fun bindSearchComponent(searchComponent: SearchComponent) {
        searchComponent.bindSearchOutput(searchResultsPresenter)
    }

    override fun onSearchResultSelected(songs: List<SongViewModel>) {
        router.onSearchResultClicked(songs.toTypedArray())
    }

    override fun onSearchSuggestionSelected(name: String) {
        searchResultsPresenter.onSearch(name)
    }

    override fun onSearchResultsReceived() {
        searchSuggestionsPresenter.loadRecentSearches()
    }
}