package com.abecerra.soundapp.scenes.player.view

import android.os.Bundle
import android.view.MenuItem
import com.abecerra.base.presentation.BaseActivity
import com.abecerra.base.utils.StringUtils
import com.abecerra.soundapp.R
import com.abecerra.soundapp.di.component.DaggerPlayerComponent
import com.abecerra.soundapp.di.module.presentation.MediaPlayerModule
import com.abecerra.soundapp.scenes.player.presenter.SongPlayerActivityPresenter
import com.soundapp.feature_commons.presentation.model.SongViewModel
import kotlinx.android.synthetic.main.view_player_toolbar.*
import javax.inject.Inject

class SongPlayerActivity : BaseActivity(), SongPlayerActivityView {

    @Inject
    lateinit var presenter: SongPlayerActivityPresenter

    override fun getLayout(): Int = R.layout.activity_song_player

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DaggerPlayerComponent.builder().mediaPlayerModule(
            MediaPlayerModule(this, getSongsFromArguments(intent.extras))
        ).build().inject(this)

        setSupportActionBar(toolbar)
        supportActionBar?.title = StringUtils.EMPTY_STRING
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_close_arrow)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        presenter.setView(this)
        presenter.loadSongPlayerFragment()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        onBackPressed()
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(0, R.anim.slide_out_down)
    }

    companion object {
        private const val PLAYLIST_EXTRA: String = "playlist_extra"

        fun buildArguments(songs: Array<SongViewModel>): Bundle {
            return Bundle().apply {
                putSerializable(PLAYLIST_EXTRA, songs)
            }
        }

        fun getSongsFromArguments(bundle: Bundle?): List<SongViewModel> {
            return (bundle?.getSerializable(PLAYLIST_EXTRA) as? Array<*>)?.map {
                it as SongViewModel
            } ?: arrayListOf()
        }
    }
}
