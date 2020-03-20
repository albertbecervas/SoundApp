package com.soundapp.feature_search

import com.soundapp.feature_search.main.SearchPresenterListener
import com.soundapp.feature_search.results.presenter.SearchResultsPresenter
import com.soundapp.feature_search.results.presenter.SearchResultsPresenterImpl
import com.soundapp.feature_search.suggestions.presenter.SearchSuggestionsPresenter
import com.soundapp.feature_search.suggestions.presenter.SearchSuggestionsPresenterImpl

object SearchConfigurator {

    fun configureSearchSuggestionsFragment(searchPresenterListener: SearchPresenterListener)
            : SearchSuggestionsPresenter {
        return SearchSuggestionsPresenterImpl(
            searchPresenterListener
        )
    }

    fun configureSearchResultsPresenter(searchPresenterListener: SearchPresenterListener)
            : SearchResultsPresenter {
        return SearchResultsPresenterImpl(
            searchPresenterListener
        )
    }
}