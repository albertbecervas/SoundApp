package com.soundapp.feature_home.presentation.model

import com.soundapp.feature_commons.presentation.model.SongViewModel

data class SectionViewModel(
    val sectionName: String,
    val songs: List<SongViewModel>
)