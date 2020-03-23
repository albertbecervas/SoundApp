package com.soundapp.database.entities

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class SongEntity(
    var wrapperType: String = "",
    @PrimaryKey
    var trackId: String = "",
    var artistName: String = "",
    var collectionName: String = "",
    var trackName: String = "",
    var collectionViewUrl: String = "",
    var trackViewUrl: String = "",
    var artistViewUrl: String = "",
    var previewUrl: String = "",
    var artworkUrl30: String = "",
    var artworkUrl60: String = "",
    var artworkUrl100: String = "",
    var collectionPrice: Double = 0.0,
    var trackPrice: Double = 0.0,
    var releaseDate: String = "",
    var collectionExplicitness: String = "",
    var trackExplicitness: String = "",
    var discCount: Int = -1,
    var discNumber: Int = -1,
    var trackCount: Int = -1,
    var trackNumber: Int = -1,
    var trackTimeMillis: Double = 0.0,
    var country: String = "",
    var currency: String = "",
    var primaryGenreName: String = "",
    var isStreamable: Boolean = false
) : RealmObject()