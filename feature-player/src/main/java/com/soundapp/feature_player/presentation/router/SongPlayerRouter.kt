package com.soundapp.feature_player.presentation.router

import android.app.PendingIntent

interface SongPlayerRouter {

    fun getSongPlayerActivityPendingIntentForNotification(): PendingIntent?

    fun shareSong(text: String)
}