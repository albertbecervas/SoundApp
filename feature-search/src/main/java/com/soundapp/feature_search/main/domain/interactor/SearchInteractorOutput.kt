package com.soundapp.feature_search.main.domain.interactor

import com.soundapp.feature_search.main.domain.model.Song

interface SearchInteractorOutput {

    fun onDefaultSongsReceived(list: List<Song>)
}