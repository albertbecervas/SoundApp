package com.soundapp.feature_search.suggestions.view

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.soundapp.feature_search.main.domain.model.RecentSearch
import kotlinx.android.synthetic.main.item_recent_search.view.*

class RecentSearchesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(
        item: RecentSearch, itemClicked: (text: String) -> Unit, onDelete: (text: String) -> Unit
    ) {
        itemView.tv_recent_search.text = item.searchTerm
        itemView.tv_recent_search.setOnClickListener {
            itemClicked(item.searchTerm)
        }
        itemView.iv_close.setOnClickListener {
            onDelete(item.searchTerm)
        }
    }
}