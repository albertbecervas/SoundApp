package com.soundapp.feature_commons.domain.model

data class Song(
    val wrapperType: String = "",
    val trackId: String,
    val artistName: String,
    val collectionName: String,
    val trackName: String,
    val collectionViewUrl: String = "",
    val trackViewUrl: String,
    val artistViewUrl: String = "",
    val previewUrl: String,
    val artworkUrl30: String = "",
    val artworkUrl60: String = "",
    val artWorkUrl100: String,
    val collectionPrice: Double = 0.0,
    val trackPrice: Double,
    val releaseDate: String,
    val collectionExplicitness: String = "",
    val trackExplicitness: String = "",
    val discCount: Int = 0,
    val discNumber: Int = 0,
    val trackCount: Int = 0,
    val trackNumber: Int = 0,
    val trackTimeMillis: Double,
    val country: String = "",
    val currency: String = "",
    val primaryGenreName: String,
    val isStreamable: Boolean = false
)
