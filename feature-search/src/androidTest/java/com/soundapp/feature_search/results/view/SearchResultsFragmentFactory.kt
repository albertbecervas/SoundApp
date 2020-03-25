package com.soundapp.feature_search.results.view

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.soundapp.feature_search.main.presentation.presenter.SearchPresenter
import com.soundapp.feature_search.results.presenter.SearchResultsPresenter
import com.soundapp.feature_search.suggestions.presenter.SearchSuggestionsPresenter

class SearchResultsFragmentFactory(private val presenter: SearchResultsPresenter) :
    FragmentFactory() {

    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        val fragment = SearchResultsFragment()
        fragment.injectPresenter(presenter)
        return fragment
    }
}