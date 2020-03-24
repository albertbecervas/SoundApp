package com.soundapp.database.dao.songs

import com.soundapp.database.entities.SavedSongEntity

interface SongsDao {

    fun addRecentlyPlayedSong(songEntity: SavedSongEntity)

    fun getRecentlyPlayed(success: (List<SavedSongEntity>) -> Unit)
}