package com.soundapp.feature_search.suggestions.view

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.soundapp.feature_search.main.presentation.presenter.SearchPresenter
import com.soundapp.feature_search.suggestions.presenter.SearchSuggestionsPresenter

class SearchSuggestionsFragmentFactory(private val presenter: SearchSuggestionsPresenter) :
    FragmentFactory() {

    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        val fragment = SearchSuggestionsFragment()
        fragment.injectPresenter(presenter)
        return fragment
    }
}