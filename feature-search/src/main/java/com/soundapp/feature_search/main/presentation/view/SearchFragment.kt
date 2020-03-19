package com.soundapp.feature_search.main.presentation.view

import android.os.Bundle
import android.view.View
import com.abecerra.base.presentation.BasePresenterFragment
import com.soundapp.feature_search.R
import com.soundapp.feature_search.main.presentation.presenter.SearchPresenter

class SearchFragment : BasePresenterFragment<SearchPresenter>(R.layout.fragment_search),
    SearchView {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter?.setView(this)
        presenter?.loadInitialSearchFragment()
    }

    override fun showLoading() {

    }

    override fun hideLoading() {

    }
}
