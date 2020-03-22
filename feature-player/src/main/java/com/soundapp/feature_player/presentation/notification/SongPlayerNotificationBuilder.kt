package com.soundapp.feature_player.presentation.notification

import android.content.Context
import com.google.android.exoplayer2.ui.PlayerNotificationManager
import com.soundapp.feature_player.R

class SongPlayerNotificationBuilder(
    private val context: Context,
    private val songPlayerNotificationAdapter: SongPlayerNotificationAdapter
) {
    fun createSongPlayerNotificationPlayer(): PlayerNotificationManager {
        return PlayerNotificationManager.createWithNotificationChannel(
            context,
            CHANNEL_ID,
            R.string.app_name,
            R.string.latino,
            NOTIFICATION_ID,
            songPlayerNotificationAdapter
        )
    }

    companion object {
        const val CHANNEL_ID = "Media Player"
        const val NOTIFICATION_ID = 1
    }
}