package com.abecerra.soundapp.navigation.routers

import com.abecerra.soundapp.navigation.navigator.Navigator
import com.abecerra.soundapp.scenes.player.SongPlayerActivity
import com.soundapp.feature_commons.presentation.model.SongViewModel
import com.soundapp.feature_home.presentation.router.HomeRouter

class HomeRouterImpl(private val navigator: Navigator) : HomeRouter {
    override fun onSongSelected(songs: Array<SongViewModel>) {
        navigator.startActivity(
            SongPlayerActivity::class.java, SongPlayerActivity.buildArguments(songs)
        )
    }
}