package com.soundapp.feature_search.main.presentation.presenter

import com.abecerra.base.presentation.BasePresenterImpl
import com.soundapp.feature_search.SearchConfigurator
import com.soundapp.feature_search.main.SearchPresenterListener
import com.soundapp.feature_search.main.presentation.router.SearchRouter
import com.soundapp.feature_search.main.presentation.view.SearchView
import com.soundapp.feature_search.results.SearchResultsFragment
import com.soundapp.feature_search.suggestions.SearchSuggestionsFragment
import java.lang.ref.WeakReference

class SearchPresenterImpl(
    private val router: SearchRouter
) : BasePresenterImpl<SearchView>(), SearchPresenter, SearchPresenterListener {

    private var searchResultsFragment: WeakReference<SearchResultsFragment>? = null

    private var searchSuggestionsFragment: WeakReference<SearchSuggestionsFragment>? = null

    override fun setSearchResultsFragment(searchResultsFragment: SearchResultsFragment?) {
        searchResultsFragment?.let {
            it.injectPresenter(SearchConfigurator.configureSearchResultsPresenter())
            this.searchResultsFragment = WeakReference(it)
        }
    }

    override fun setSearchSuggestionsFragment(searchSuggestionsFragment: SearchSuggestionsFragment?) {
        searchSuggestionsFragment?.let {
            it.injectPresenter(SearchConfigurator.configureSearchSuggestionsFragment(this))
            this.searchSuggestionsFragment = WeakReference(it)
        }
    }

    override fun onSearch(text: String) {
        searchResultsFragment?.get()?.setResults(arrayListOf())
    }

    override fun emptySearch() {
        searchResultsFragment?.get()?.clearResults()
    }
}