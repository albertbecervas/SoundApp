package com.soundapp.feature_commons.presentation.model

import java.io.Serializable

data class SongViewModel(
    val name: String,
    val artist: String,
    val album: String,
    val imageUrl: String,
    val duration: String,
    val date: String,
    val price: String,
    val genre: String,
    val preview: String
) : Serializable
