package com.soundapp.feature_home.domain.model

import com.soundapp.feature_commons.domain.model.Song

data class HomeSection(
    val sectionName: String,
    val songs: List<Song>
)