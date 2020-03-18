package com.soundapp.feature_home.domain.repository

import com.soundapp.feature_home.domain.model.Song

interface HomeRepositoryOutput {

    fun onRockSongsReceived(list: List<Song>)
}