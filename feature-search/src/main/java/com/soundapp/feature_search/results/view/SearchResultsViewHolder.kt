package com.soundapp.feature_search.results.view

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.soundapp.feature_commons.presentation.model.SongViewModel
import com.soundapp.feature_search.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_search_result.view.*

class SearchResultsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(songViewModel: SongViewModel, onItemClick: (song: SongViewModel) -> Unit) {
        Picasso.get().load(songViewModel.imageUrl).into(itemView.iv_preview)
        itemView.tv_title_song.text = songViewModel.name
        itemView.tv_artist.text = songViewModel.artist
        itemView.setOnClickListener { onItemClick(songViewModel) }
    }
}