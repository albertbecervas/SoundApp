package com.soundapp.database.entities

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class SavedSongEntity(
    @PrimaryKey
    var trackId: String = "",
    var artistName: String = "",
    var collectionName: String = "",
    var trackName: String = "",
    var trackViewUrl: String = "",
    var previewUrl: String = "",
    var artWorkUrl100: String = "",
    var trackPrice: String = "",
    var releaseDate: String = "",
    var duration: String = "",
    var primaryGenreName: String = ""
) : RealmObject()