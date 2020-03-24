package com.abecerra.soundapp.navigation.routers

import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_NEW_TASK
import androidx.core.app.TaskStackBuilder
import com.abecerra.soundapp.navigation.navigator.Navigator
import com.abecerra.soundapp.scenes.player.SongPlayerActivity
import com.soundapp.feature_commons.presentation.model.SongViewModel
import com.soundapp.feature_player.presentation.router.SongPlayerRouter

class SongPlayerRouterImpl(
    private val navigator: Navigator,
    private val context: Context,
    private val songsList: List<SongViewModel>
) : SongPlayerRouter {
    override fun getSongPlayerActivityPendingIntentForNotification(): PendingIntent? {
        val intent = Intent(context, SongPlayerActivity::class.java)
        intent.flags = FLAG_ACTIVITY_NEW_TASK
        intent.putExtras(SongPlayerActivity.buildArguments(songsList.toTypedArray()))
        return TaskStackBuilder.create(context).run {
            addNextIntentWithParentStack(intent)
            getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT)
        }
    }

    override fun shareSong(text: String) {
        navigator.share(text)
    }
}