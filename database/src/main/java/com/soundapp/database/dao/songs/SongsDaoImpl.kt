package com.soundapp.database.dao.songs

import com.soundapp.database.entities.SavedSongEntity
import io.realm.Realm

class SongsDaoImpl(private val realm: Realm) : SongsDao {

    override fun addRecentlyPlayedSong(songEntity: SavedSongEntity) {
        realm.executeTransactionAsync {
            it.insertOrUpdate(songEntity)
        }
    }

    override fun getRecentlyPlayed(success: (List<SavedSongEntity>) -> Unit) {
        realm.executeTransaction {
            val list: List<SavedSongEntity> =
                it.where(SavedSongEntity::class.java).findAll().reversed()
            if (list.isNotEmpty()) success(list)
        }
    }
}