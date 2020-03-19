package com.soundapp.feature_search.main.presentation.presenter

import com.abecerra.base.presentation.BasePresenter
import com.soundapp.feature_search.main.presentation.view.SearchView

interface SearchPresenter : BasePresenter<SearchView> {

    fun loadInitialSearchFragment()
}