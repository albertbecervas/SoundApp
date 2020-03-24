package com.abecerra.soundapp.di.component

import com.abecerra.soundapp.di.module.data.DataBaseModule
import com.abecerra.soundapp.di.module.presentation.MediaPlayerModule
import com.abecerra.soundapp.scenes.player.SongPlayerActivity
import dagger.Component
import javax.inject.Singleton

@Component(
    modules = [MediaPlayerModule::class, DataBaseModule::class]
)
interface PlayerComponent {

    fun inject(songPlayerActivity: SongPlayerActivity)
}