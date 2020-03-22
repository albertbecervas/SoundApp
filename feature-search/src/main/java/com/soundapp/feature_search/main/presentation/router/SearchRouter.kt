package com.soundapp.feature_search.main.presentation.router

import com.soundapp.feature_commons.presentation.model.SongViewModel

interface SearchRouter {

    fun onSearchResultClicked(songs: Array<SongViewModel>)
}