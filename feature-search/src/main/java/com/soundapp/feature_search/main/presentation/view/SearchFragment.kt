package com.soundapp.feature_search.main.presentation.view

import android.os.Bundle
import android.view.View
import com.abecerra.base.presentation.BasePresenterFragment
import com.soundapp.feature_search.R
import com.soundapp.feature_search.main.presentation.presenter.SearchPresenter
import com.soundapp.feature_search.results.SearchResultsFragment
import com.soundapp.feature_search.suggestions.SearchSuggestionsFragment
import kotlinx.android.synthetic.main.fragment_search.*

class SearchFragment : BasePresenterFragment<SearchPresenter>(R.layout.fragment_search),
    SearchView {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter?.let {
            it.setView(this)
            it.setSearchResultsFragment(childFragmentManager
                .findFragmentById(R.id.fl_search_results) as? SearchResultsFragment)
            it.setSearchSuggestionsFragment(childFragmentManager
                .findFragmentById(R.id.fl_search_suggestions) as? SearchSuggestionsFragment)
            searchComponent?.bindSearchOutput(it)
        }
    }
}
