package com.abecerra.soundapp.di.module.data

import com.soundapp.database.dao.search.SearchesDao
import com.soundapp.database.dao.search.SearchesDaoImpl
import com.soundapp.database.dao.songs.SongsDao
import com.soundapp.database.dao.songs.SongsDaoImpl
import dagger.Module
import dagger.Provides
import io.realm.Realm
import io.realm.RealmConfiguration


@Module
class DataBaseModule {

    @Provides
    fun provideRealm(): Realm {
        val mRealmConfiguration = RealmConfiguration.Builder()
            .name("SoundApp.realm")
            .deleteRealmIfMigrationNeeded()
            .build()
        Realm.getInstance(mRealmConfiguration)
        Realm.setDefaultConfiguration(mRealmConfiguration)
        return Realm.getDefaultInstance()
    }

    @Provides
    fun provideSongsDao(realm: Realm): SongsDao {
        return SongsDaoImpl(realm)
    }

    @Provides
    fun provideSearchesDao(realm: Realm): SearchesDao {
        return SearchesDaoImpl(realm)
    }
}