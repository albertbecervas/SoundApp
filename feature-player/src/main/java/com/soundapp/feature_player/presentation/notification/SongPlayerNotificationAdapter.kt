package com.soundapp.feature_player.presentation.notification

import android.app.PendingIntent
import android.graphics.Bitmap
import com.abecerra.base.utils.StringUtils
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.ui.PlayerNotificationManager
import com.soundapp.feature_commons.presentation.model.SongViewModel
import com.soundapp.feature_player.presentation.router.SongPlayerRouter

class SongPlayerNotificationAdapter(
    private val songPlayerRouter: SongPlayerRouter
) :
    PlayerNotificationManager.MediaDescriptionAdapter {
    override fun createCurrentContentIntent(player: Player): PendingIntent? =
        songPlayerRouter.getSongPlayerActivityPendingIntentForNotification()

    override fun getCurrentContentText(player: Player): String? =
        getSongFromTag(player.currentTag)?.artist

    override fun getCurrentContentTitle(player: Player): String =
        getSongFromTag(player.currentTag)?.name ?: StringUtils.EMPTY_STRING

    override fun getCurrentLargeIcon(
        player: Player, callback: PlayerNotificationManager.BitmapCallback
    ): Bitmap? = null

    private fun getSongFromTag(tag: Any?): SongViewModel? = tag as? SongViewModel
}