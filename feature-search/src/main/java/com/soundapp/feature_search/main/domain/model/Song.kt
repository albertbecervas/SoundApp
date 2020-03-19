package com.soundapp.feature_search.main.domain.model

data class Song(
    val wrapperType: String,
    val artistName: String,
    val collectionName: String,
    val trackName: String,
    val collectionViewUrl: String,
    val trackViewUrl: String,
    val artistViewUrl: String,
    val previewUrl: String,
    val artworkUrl30: String,
    val artworkUrl60: String,
    val artWorkUrl100: String,
    val collectionPrice: Double,
    val trackPrice: Double,
    val releaseDate: String,
    val collectionExplicitness: String,
    val trackExplicitness: String,
    val discCount: Int,
    val discNumber: Int,
    val trackCount: Int,
    val trackNumber: Int,
    val trackTimeMillis: Double,
    val country: String,
    val currency: String,
    val primaryGenreName: String,
    val isStreamable: Boolean
)
