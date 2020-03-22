package com.abecerra.soundapp.navigation.routers

import com.abecerra.soundapp.navigation.navigator.Navigator
import com.abecerra.soundapp.scenes.player.SongPlayerActivity
import com.soundapp.feature_commons.presentation.model.SongViewModel
import com.soundapp.feature_search.main.presentation.router.SearchRouter

class SearchRouterImpl(
    private val navigator: Navigator
) : SearchRouter {
    override fun onSearchResultClicked(songs: Array<SongViewModel>) {
        navigator.startActivity(
            SongPlayerActivity::class.java, SongPlayerActivity.buildArguments(songs)
        )
    }
}