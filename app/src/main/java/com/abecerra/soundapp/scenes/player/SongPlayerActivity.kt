package com.abecerra.soundapp.scenes.player

import android.os.Bundle
import com.abecerra.base.presentation.BaseActivity
import com.abecerra.soundapp.R
import com.abecerra.soundapp.di.component.DaggerPlayerComponent
import com.abecerra.soundapp.di.module.presentation.MediaPlayerModule
import com.soundapp.feature_commons.presentation.model.SongViewModel
import com.soundapp.feature_player.presentation.view.SongPlayerFragment
import javax.inject.Inject

class SongPlayerActivity : BaseActivity() {

    @Inject
    lateinit var fragment: SongPlayerFragment

    override fun getLayout(): Int = R.layout.activity_song_player

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DaggerPlayerComponent.builder().mediaPlayerModule(
            MediaPlayerModule(this, getSongsFromArguments(intent.extras))
        ).build().inject(this)

        supportFragmentManager.beginTransaction().replace(R.id.fl_player, fragment).commit()
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
