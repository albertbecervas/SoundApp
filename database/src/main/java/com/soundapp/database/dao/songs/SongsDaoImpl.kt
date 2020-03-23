package com.soundapp.database.dao.songs

import com.soundapp.database.entities.SongEntity
import io.realm.Realm

class SongsDaoImpl(private val realm: Realm) : SongsDao {

    override fun addRecentlyPlayedSong(songEntity: SongEntity) {
        realm.executeTransactionAsync {
            it.insert(songEntity)
        }
    }

    override fun getRecentlyPlayed(success: (List<SongEntity>) -> Unit) {
        realm.executeTransactionAsync {
            val list: List<SongEntity> =
                it.where(SongEntity::class.java).findAllAsync().subList(0, 10)
            success(list)
        }
    }
}