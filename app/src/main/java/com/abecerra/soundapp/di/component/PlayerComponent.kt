package com.abecerra.soundapp.di.component

import com.abecerra.soundapp.di.module.data.DataBaseModule
import com.abecerra.soundapp.di.module.presentation.MediaPlayerModule
import com.abecerra.soundapp.di.module.presentation.NavigationModule
import com.abecerra.soundapp.scenes.player.view.SongPlayerActivity
import dagger.Component

@Component(
    modules = [MediaPlayerModule::class, DataBaseModule::class, NavigationModule::class]
)
interface PlayerComponent {

    fun inject(songPlayerActivity: SongPlayerActivity)
}