package com.soundapp.feature_search.suggestions.view

import android.view.ViewGroup
import com.abecerra.base.presentation.BaseAdapter
import com.abecerra.base.utils.inflate
import com.soundapp.feature_search.R
import com.soundapp.feature_search.main.domain.model.RecentSearch

class RecentSearchesAdapter(
    private val itemClicked: (text: String) -> Unit,
    private val onDelete: (text: String) -> Unit
) : BaseAdapter<RecentSearchesViewHolder, RecentSearch>() {
    override fun onBindViewHolder(holder: RecentSearchesViewHolder, item: RecentSearch, pos: Int) {
        holder.bind(item, itemClicked, onDelete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecentSearchesViewHolder {
        return RecentSearchesViewHolder(parent.inflate(R.layout.item_recent_search))
    }

}