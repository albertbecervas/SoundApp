package com.soundapp.feature_search.suggestions.view

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.abecerra.base.presentation.BasePresenterFragment
import com.soundapp.feature_search.R
import com.soundapp.feature_search.suggestions.presenter.SearchSuggestionsPresenter
import kotlinx.android.synthetic.main.fragment_search_suggestions.*

class SearchSuggestionsFragment :
    BasePresenterFragment<SearchSuggestionsPresenter>(R.layout.fragment_search_suggestions),
    SearchSuggestionsView {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    override fun injectPresenter(presenter: SearchSuggestionsPresenter) {
        super.injectPresenter(presenter)
        presenter.setView(this)
    }

    override fun onResume() {
        super.onResume()
        presenter?.loadSearchSuggestions()
        presenter?.loadRecentSearches()
    }

    private fun initViews() {
        rv_suggestions.layoutManager = GridLayoutManager(context, SPAN_COUNT)
        rv_suggestions.adapter = presenter?.getSearchSuggestionsAdapter()

        rv_recently_listened.layoutManager = LinearLayoutManager(context)
        rv_recently_listened.adapter = presenter?.getRecentSearchesAdapter()
    }

    override fun showRecents() {
        cl_recently_listened.visibility = View.VISIBLE
    }

    override fun hideRecents() {
        cl_recently_listened.visibility = View.GONE
    }

    companion object {
        const val SPAN_COUNT = 2
    }
}
