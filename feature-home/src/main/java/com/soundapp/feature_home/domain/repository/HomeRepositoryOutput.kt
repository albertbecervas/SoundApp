package com.soundapp.feature_home.domain.repository

import com.soundapp.feature_commons.domain.model.Song

interface HomeRepositoryOutput {

    fun onRockSongsReceived(list: List<com.soundapp.feature_commons.domain.model.Song>)
}