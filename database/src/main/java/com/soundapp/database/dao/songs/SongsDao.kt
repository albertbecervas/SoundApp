package com.soundapp.database.dao.songs

import com.soundapp.database.entities.SongEntity

interface SongsDao {

    fun addRecentlyPlayedSong(songEntity: SongEntity)

    fun getRecentlyPlayed(success: (List<SongEntity>) -> Unit)
}