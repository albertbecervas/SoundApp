package com.soundapp.feature_search.results.view

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.soundapp.feature_search.main.presentation.model.SearchSongViewModel
import kotlinx.android.synthetic.main.item_search_result.view.*

class SearchResultsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(songViewModel: SearchSongViewModel, onItemClick: (id: String) -> Unit) {
        itemView.tv_title_song.text = songViewModel.name
        itemView.tv_artist.text = songViewModel.artist
        itemView.setOnClickListener { onItemClick(songViewModel.id) }
    }
}