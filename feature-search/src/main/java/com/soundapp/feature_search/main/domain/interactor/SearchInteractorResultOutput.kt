package com.soundapp.feature_search.main.domain.interactor

import com.soundapp.feature_commons.domain.model.Song

interface SearchInteractorResultOutput {

    fun onSearchSongsReceived(list: List<Song>)

    fun onNoResultsFound()
}