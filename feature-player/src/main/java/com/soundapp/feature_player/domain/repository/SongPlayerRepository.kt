package com.soundapp.feature_player.domain.repository

import com.abecerra.base.data.BaseRepository
import com.soundapp.feature_commons.domain.model.SavedSong

interface SongPlayerRepository : BaseRepository<SongPlayerRepositoryOutput> {

    fun saveSongPlayed(savedSong: SavedSong)
}