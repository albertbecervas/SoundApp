package com.soundapp.feature_commons.presentation.model

import java.io.Serializable

data class SongViewModel(
    val name: String,
    val artist: String,
    val imageUrl: String,
    val duration: String,
    val price: String,
    val preview: String
): Serializable
