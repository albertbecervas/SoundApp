package com.soundapp.feature_search.results


import android.os.Bundle
import android.view.View
import com.abecerra.base.presentation.BasePresenterFragment
import com.abecerra.components.search.SearchComponentOutput
import com.soundapp.feature_search.R
import kotlinx.android.synthetic.main.fragment_search_results.*

class SearchResultsFragment :
    BasePresenterFragment<SearchResultsPresenter>(R.layout.fragment_search_results),
    SearchResultsView {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter?.setView(this)
    }

    fun setResults(list: List<Any>){
        tv.visibility = View.VISIBLE
    }

    fun clearResults(){
        tv.visibility = View.GONE
    }
}

