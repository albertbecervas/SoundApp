package com.soundapp.feature_search.main.domain.repository

import com.soundapp.feature_search.main.domain.model.Song

interface SearchRepositoryOutput {

    fun onRockSongsReceived(list: List<Song>)
}