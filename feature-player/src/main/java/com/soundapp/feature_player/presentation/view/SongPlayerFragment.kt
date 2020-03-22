package com.soundapp.feature_player.presentation.view

import android.os.Bundle
import android.view.View
import com.abecerra.base.presentation.BasePresenterFragment
import com.soundapp.feature_commons.presentation.model.SongViewModel
import com.soundapp.feature_player.R
import com.soundapp.feature_player.presentation.presenter.SongPlayerPresenter
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_song_player.*


class SongPlayerFragment :
    BasePresenterFragment<SongPlayerPresenter>(R.layout.fragment_song_player), SongPlayerView {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter?.setView(this)
    }

    override fun onResume() {
        super.onResume()
        player_view?.player = presenter?.initPlayer()
    }

    override fun songDataUpdated(songViewModel: SongViewModel) {
        tv_song_title?.text = songViewModel.name
        tv_song_artist?.text = songViewModel.artist
        iv_song_preview?.let { Picasso.get().load(songViewModel.imageUrl).into(it) }
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter?.onViewDestroyed()
    }
}
