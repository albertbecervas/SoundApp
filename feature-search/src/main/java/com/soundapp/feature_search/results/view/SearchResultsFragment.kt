package com.soundapp.feature_search.results.view


import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.abecerra.base.presentation.BasePresenterFragment
import com.soundapp.feature_search.R
import com.soundapp.feature_search.main.presentation.model.SearchSongViewModel
import com.soundapp.feature_search.results.presenter.SearchResultsPresenter
import kotlinx.android.synthetic.main.fragment_search_results.*

class SearchResultsFragment :
    BasePresenterFragment<SearchResultsPresenter>(R.layout.fragment_search_results),
    SearchResultsView {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() {
        rv_search_results.layoutManager = LinearLayoutManager(context)
        rv_search_results.adapter = presenter?.getSearchResultsAdapter()
    }

    override fun injectPresenter(presenter: SearchResultsPresenter) {
        super.injectPresenter(presenter)
        presenter.setView(this)
    }

    fun setResults(list: List<SearchSongViewModel>) {
        presenter?.setResults(list)
    }

    fun clearResults() {
        presenter?.clearResults()
    }
}

