package com.soundapp.feature_search.suggestions.presenter

import com.abecerra.base.presentation.BasePresenterImpl
import com.soundapp.feature_search.main.domain.interactor.SearchInteractor
import com.soundapp.feature_search.main.domain.interactor.SearchInteractorSuggestionsOutput
import com.soundapp.feature_search.main.domain.model.RecentSearch
import com.soundapp.feature_search.main.presentation.presenter.SearchPresenterListener
import com.soundapp.feature_search.suggestions.view.RecentSearchesAdapter
import com.soundapp.feature_search.suggestions.view.SearchSuggestionsAdapter
import com.soundapp.feature_search.suggestions.view.SearchSuggestionsView

class SearchSuggestionsPresenterImpl(
    private val searchPresenterListener: SearchPresenterListener,
    private val searchInteractor: SearchInteractor
) : BasePresenterImpl<SearchSuggestionsView>(), SearchSuggestionsPresenter,
    SearchInteractorSuggestionsOutput {

    private val searchSuggestionsAdapter = SearchSuggestionsAdapter {
        searchPresenterListener.onSearchSuggestionSelected(it)
    }

    private val recentSearchesAdapter = RecentSearchesAdapter({
        searchInteractor.searchSongs(it)
    }, {
        deleteSearchEntry(it)
    })

    init {
        searchInteractor.setSearchSuggestionsOutput(this)
    }

    override fun getSearchSuggestionsAdapter(): SearchSuggestionsAdapter = searchSuggestionsAdapter

    override fun getRecentSearchesAdapter(): RecentSearchesAdapter = recentSearchesAdapter

    override fun loadSearchSuggestions() {
        searchSuggestionsAdapter.setItems(searchInteractor.getSearchSuggestions())
    }

    override fun loadRecentSearches() {
        searchInteractor.getRecentSearches()
    }

    override fun onRecentSearchesFound(list: List<RecentSearch>) {
        getView()?.showRecents()
        recentSearchesAdapter.setItems(list)
    }

    override fun onEmptyRecentSearches() {
        getView()?.hideRecents()
    }

    private fun deleteSearchEntry(text: String) {
        searchInteractor.removeRecentSearch(text)
        recentSearchesAdapter.remove(RecentSearch(text))
        if (recentSearchesAdapter.getItems().isEmpty()) getView()?.hideRecents()
    }
}