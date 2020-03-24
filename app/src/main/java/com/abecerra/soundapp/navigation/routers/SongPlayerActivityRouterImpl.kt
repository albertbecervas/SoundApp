package com.abecerra.soundapp.navigation.routers

import com.abecerra.soundapp.navigation.navigator.Navigator
import com.abecerra.soundapp.scenes.player.router.SongPlayerActivityRouter
import com.soundapp.feature_player.presentation.view.SongPlayerFragment

class SongPlayerActivityRouterImpl(
    private val navigator: Navigator, private val songPlayerFragment: SongPlayerFragment
) : SongPlayerActivityRouter {
    override fun loadSongPlayerFragment(layout: Int) {
        navigator.replaceFragment(songPlayerFragment, layout)
    }
}