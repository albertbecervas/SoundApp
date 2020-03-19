package com.soundapp.feature_home.presentation.presenter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.soundapp.feature_home.presentation.model.SongViewModel
import kotlinx.android.synthetic.main.item_home_song.view.*

class HomeSongViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(item: SongViewModel) {
        itemView.tv_song_title?.text = item.name
    }
}