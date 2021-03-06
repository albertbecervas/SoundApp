package com.soundapp.feature_search.results.view

import com.abecerra.base.presentation.BaseView

interface SearchResultsView : BaseView {

    fun showLoading()

    fun hideLoading()

    fun showEmptyResults()

    fun hideEmptyResults()

    fun showSortComponent()

    fun hideSortComponent()
}