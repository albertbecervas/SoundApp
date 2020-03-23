package com.soundapp.feature_search.results.view


import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.abecerra.base.presentation.BasePresenterFragment
import com.soundapp.feature_search.R
import com.soundapp.feature_search.results.presenter.SearchResultsPresenter
import kotlinx.android.synthetic.main.fragment_search_results.*

class SearchResultsFragment :
    BasePresenterFragment<SearchResultsPresenter>(R.layout.fragment_search_results),
    SearchResultsView {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter?.setView(this)
        initViews()
        setHasOptionsMenu(true)
    }

    private fun initViews() {
        rv_search_results.layoutManager = LinearLayoutManager(context)
        rv_search_results.adapter = presenter?.getSearchResultsAdapter()
        presenter?.bindSortComponent(sortComponent)
    }

    override fun showLoading() {
        loading.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        loading.visibility = View.GONE
    }

    override fun showEmptyResults() {
        tv_empty_results.visibility = View.VISIBLE
    }

    override fun hideEmptyResults() {
        tv_empty_results.visibility = View.GONE
    }

    override fun showSortComponent() {
        sortComponent.visibility = View.VISIBLE
    }

    override fun hideSortComponent() {
        sortComponent.visibility = View.GONE
    }
}

