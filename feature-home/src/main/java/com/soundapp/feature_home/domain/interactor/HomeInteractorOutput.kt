package com.soundapp.feature_home.domain.interactor

import com.soundapp.feature_commons.domain.model.Song

interface HomeInteractorOutput {

    fun onDefaultSongsReceived(list: List<com.soundapp.feature_commons.domain.model.Song>)
}