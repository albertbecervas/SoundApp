package com.soundapp.feature_home.domain.interactor

import com.soundapp.feature_home.domain.model.Song

interface HomeInteractorOutput {

    fun onDefaultSongsReceived(list: List<Song>)
}