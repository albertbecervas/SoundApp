package com.soundapp.feature_search.main.domain.interactor

import com.soundapp.feature_search.main.domain.model.SearchSong

interface SearchInteractorOutput {

    fun onSearchSongsReceived(list: List<SearchSong>)
}