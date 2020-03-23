package com.soundapp.feature_search.results.view

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.soundapp.feature_commons.presentation.model.SongViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_search_result.view.*

class SearchResultsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(songViewModel: SongViewModel, onItemClick: (song: SongViewModel) -> Unit) {
        with(songViewModel) {
            Picasso.get().load(imageUrl).into(itemView.iv_preview)
            itemView.tv_title_song.text = name
            val artist = if (artist.length > MAX_ARTIST_LENGTH)
                "${artist.substring(0, MAX_ARTIST_LENGTH)}..."
            else artist
            itemView.tv_artist.text = artist
            itemView.tv_album.text = album
            itemView.tv_price.text = price
            itemView.tv_genre.text = genre
            itemView.tv_date.text = date
            itemView.tv_duration.text = duration

            itemView.setOnClickListener { onItemClick(this) }
        }
    }

    companion object {
        private const val MAX_ARTIST_LENGTH = 15
    }
}