package com.soundapp.feature_home.presentation.presenter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.soundapp.feature_commons.presentation.model.SongViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_home_song.view.*

class HomeSongViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(item: SongViewModel, onItemClick: (item: SongViewModel) -> Unit) {
        itemView.tv_song_title?.text = item.name
        Picasso.get().load(item.imageUrl).into(itemView.iv_preview)
        itemView.setOnClickListener {
            onItemClick(item)
        }
    }
}