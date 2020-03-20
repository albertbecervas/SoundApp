package com.soundapp.feature_search.main

interface SearchPresenterListener {

    fun onSearchResultSelected(id: String)

    fun onSearchSuggestionSelected(name: String)
}