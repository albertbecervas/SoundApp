package com.soundapp.feature_player.data

import com.abecerra.base.data.BaseRepositoryImpl
import com.soundapp.database.dao.songs.SongsDao
import com.soundapp.feature_commons.data.SongEntityMapper
import com.soundapp.feature_commons.domain.model.SavedSong
import com.soundapp.feature_player.domain.repository.SongPlayerRepository
import com.soundapp.feature_player.domain.repository.SongPlayerRepositoryOutput

class SongPlayerRepositoryImpl(private val songsDao: SongsDao) :
    BaseRepositoryImpl<SongPlayerRepositoryOutput>(),
    SongPlayerRepository {

    override fun saveSongPlayed(savedSong: SavedSong) {
        songsDao.addRecentlyPlayedSong(SongEntityMapper.mapToSongEntity(savedSong))
    }
}