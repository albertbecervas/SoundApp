package com.soundapp.feature_search.results.view

import android.view.ViewGroup
import com.abecerra.base.presentation.BaseAdapter
import com.abecerra.base.utils.inflate
import com.soundapp.feature_commons.presentation.model.SongViewModel
import com.soundapp.feature_search.R

class SearchResultsAdapter(private val onItemClick: (song: SongViewModel) -> Unit) :
    BaseAdapter<SearchResultsViewHolder, SongViewModel>() {
    override fun onBindViewHolder(holder: SearchResultsViewHolder, item: SongViewModel, pos: Int) {
        holder.bind(item, onItemClick)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchResultsViewHolder {
        return SearchResultsViewHolder(
            parent.inflate(R.layout.item_search_result)
        )
    }
}