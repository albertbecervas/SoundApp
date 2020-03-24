package com.soundapp.feature_home.domain.interactor

import com.soundapp.feature_commons.domain.model.SavedSong
import com.soundapp.feature_home.domain.model.HomeSection

interface HomeInteractorOutput {

    fun onRecentPlayedFound(sectionName: String, list: List<SavedSong>)

    fun onInitialSectionsReady(list: List<HomeSection>)
}