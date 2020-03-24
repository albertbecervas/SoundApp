package com.soundapp.feature_commons.domain.model

data class SavedSong(
    val trackId: String,
    val artistName: String,
    val collectionName: String,
    val trackName: String,
    val trackViewUrl: String,
    val previewUrl: String,
    val artWorkUrl100: String,
    val trackPrice: String,
    val releaseDate: String,
    val duration: String,
    val primaryGenreName: String
)
