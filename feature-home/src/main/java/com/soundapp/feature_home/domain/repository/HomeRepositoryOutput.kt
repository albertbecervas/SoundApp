package com.soundapp.feature_home.domain.repository

import com.soundapp.feature_commons.domain.model.SavedSong
import com.soundapp.feature_commons.domain.model.Song

interface HomeRepositoryOutput {

    fun onRockSongsReceived(list: List<Song>)
    fun onLatinoSongsReceived(list: List<Song>)
    fun onJazzSongsReceived(list: List<Song>)
    fun onPopSongsReceived(list: List<Song>)

    fun onRecentlyPlayedSongsFound(list: List<SavedSong>)
}