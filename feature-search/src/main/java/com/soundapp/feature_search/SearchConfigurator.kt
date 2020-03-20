package com.soundapp.feature_search

import com.soundapp.feature_search.main.SearchPresenterListener
import com.soundapp.feature_search.results.SearchResultsPresenter
import com.soundapp.feature_search.results.SearchResultsPresenterImpl
import com.soundapp.feature_search.suggestions.SearchSuggestionsPresenter
import com.soundapp.feature_search.suggestions.SearchSuggestionsPresenterImpl

object SearchConfigurator {

    fun configureSearchSuggestionsFragment(searchPresenterListener: SearchPresenterListener)
            : SearchSuggestionsPresenter {
        return SearchSuggestionsPresenterImpl(searchPresenterListener)
    }

    fun configureSearchResultsPresenter(): SearchResultsPresenter {
        return SearchResultsPresenterImpl()
    }
}