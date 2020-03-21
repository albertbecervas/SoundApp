package com.soundapp.feature_search.main.presentation.presenter

interface SearchPresenterListener {

    fun onSearchResultSelected(id: String)

    fun onSearchSuggestionSelected(name: String)
}