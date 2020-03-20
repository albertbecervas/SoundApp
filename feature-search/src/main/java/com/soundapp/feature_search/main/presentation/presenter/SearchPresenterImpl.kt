package com.soundapp.feature_search.main.presentation.presenter

import com.abecerra.base.presentation.BasePresenterImpl
import com.soundapp.feature_search.SearchConfigurator
import com.soundapp.feature_search.main.SearchPresenterListener
import com.soundapp.feature_search.main.domain.interactor.SearchInteractor
import com.soundapp.feature_search.main.domain.interactor.SearchInteractorOutput
import com.soundapp.feature_search.main.domain.model.SearchSong
import com.soundapp.feature_search.main.presentation.model.SearchSongViewModelMapper
import com.soundapp.feature_search.main.presentation.router.SearchRouter
import com.soundapp.feature_search.main.presentation.view.SearchView
import com.soundapp.feature_search.results.view.SearchResultsFragment
import com.soundapp.feature_search.suggestions.view.SearchSuggestionsFragment
import java.lang.ref.WeakReference

class SearchPresenterImpl(
    private val router: SearchRouter, private val interactor: SearchInteractor
) : BasePresenterImpl<SearchView>(), SearchPresenter, SearchPresenterListener,
    SearchInteractorOutput {

    private var searchResultsFragment: WeakReference<SearchResultsFragment>? = null

    private var searchSuggestionsFragment: WeakReference<SearchSuggestionsFragment>? = null

    init {
        interactor.setInteractorOutput(this)
    }

    override fun getSearchResultsFragment(): SearchResultsFragment {
        val fragment = SearchResultsFragment()
        fragment.injectPresenter(SearchConfigurator.configureSearchResultsPresenter(this))
        searchResultsFragment = WeakReference(fragment)
        return fragment
    }

    override fun getSearchSuggestionsFragment(): SearchSuggestionsFragment {
        val fragment = SearchSuggestionsFragment()
        fragment.injectPresenter(SearchConfigurator.configureSearchSuggestionsFragment(this))
        searchSuggestionsFragment = WeakReference(fragment)
        return fragment
    }

    override fun onSearch(text: String) {
        interactor.searchSongs(text)
    }

    override fun onSearchSongsReceived(list: List<SearchSong>) {
        searchResultsFragment?.get()?.setResults(SearchSongViewModelMapper.mapSongs(list))
    }

    override fun emptySearch() {
        searchResultsFragment?.get()?.clearResults()
    }

    override fun onSearchResultSelected(id: String) {
        router.onSearchResultClicked(id)
    }

    override fun onSearchSuggestionSelected(name: String) {
        interactor.searchSongs(name)
    }
}