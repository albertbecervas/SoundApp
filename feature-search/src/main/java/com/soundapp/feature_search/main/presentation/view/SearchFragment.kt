package com.soundapp.feature_search.main.presentation.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.replace
import com.abecerra.base.presentation.BasePresenterFragment
import com.soundapp.feature_search.R
import com.soundapp.feature_search.main.presentation.presenter.SearchPresenter
import com.soundapp.feature_search.results.view.SearchResultsFragment
import com.soundapp.feature_search.suggestions.view.SearchSuggestionsFragment
import kotlinx.android.synthetic.main.fragment_search.*

class SearchFragment : BasePresenterFragment<SearchPresenter>(R.layout.fragment_search),
    SearchView {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter?.let {
            it.setView(this)
            childFragmentManager.beginTransaction()
                .add(R.id.fl_search_results, it.getSearchResultsFragment()).commit()
            childFragmentManager.beginTransaction()
                .add(R.id.fl_search_suggestions, it.getSearchSuggestionsFragment()).commit()
            searchComponent?.bindSearchOutput(it)
        }
    }
}
