package com.soundapp.feature_search.main.presentation.presenter

import com.soundapp.feature_commons.presentation.model.SongViewModel

interface SearchPresenterListener {

    fun onSearchResultSelected(songs: List<SongViewModel>)

    fun onSearchSuggestionSelected(name: String)

    fun onSearchResultsReceived()
}