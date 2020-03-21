package com.soundapp.feature_search

import com.abecerra.appresources.Translator
import com.soundapp.feature_search.main.presentation.presenter.SearchPresenterListener
import com.soundapp.feature_search.main.domain.interactor.SearchInteractor
import com.soundapp.feature_search.results.presenter.SearchResultsPresenter
import com.soundapp.feature_search.results.presenter.SearchResultsPresenterImpl
import com.soundapp.feature_search.suggestions.presenter.SearchSuggestionsPresenter
import com.soundapp.feature_search.suggestions.presenter.SearchSuggestionsPresenterImpl

object SearchConfigurator {

    fun configureSearchSuggestionsFragment(
        searchPresenterListener: SearchPresenterListener,
        translator: Translator
    ): SearchSuggestionsPresenter {
        return SearchSuggestionsPresenterImpl(searchPresenterListener, translator)
    }

    fun configureSearchResultsPresenter(
        searchPresenterListener: SearchPresenterListener,
        searchInteractor: SearchInteractor
    ): SearchResultsPresenter {
        return SearchResultsPresenterImpl(searchPresenterListener, searchInteractor)
    }
}