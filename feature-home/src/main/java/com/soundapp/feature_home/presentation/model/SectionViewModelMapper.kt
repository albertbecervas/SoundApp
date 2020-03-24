package com.soundapp.feature_home.presentation.model

import com.soundapp.feature_commons.domain.model.SavedSong
import com.soundapp.feature_commons.presentation.SongViewModelMapper
import com.soundapp.feature_commons.presentation.model.SongViewModel
import com.soundapp.feature_home.domain.model.HomeSection

object SectionViewModelMapper {

    fun map(from: List<HomeSection>): List<SectionViewModel> {
        return from.map { map(it) }
    }

    private fun map(from: HomeSection): SectionViewModel {
        return with(from) {
            SectionViewModel(sectionName, SongViewModelMapper.mapSongs(songs))
        }
    }

    fun map(sectionName: String, list: List<SavedSong>): SectionViewModel {
        return SectionViewModel(sectionName, SongViewModelMapper.mapSavedSongs(list))
    }
}