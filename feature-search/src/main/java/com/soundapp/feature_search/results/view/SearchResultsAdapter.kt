package com.soundapp.feature_search.results.view

import android.view.ViewGroup
import com.abecerra.base.presentation.BaseAdapter
import com.abecerra.base.utils.inflate
import com.soundapp.feature_search.R
import com.soundapp.feature_search.main.presentation.model.SearchSongViewModel

class SearchResultsAdapter(private val onItemClick: (id: String) -> Unit) :
    BaseAdapter<SearchResultsViewHolder, SearchSongViewModel>() {
    override fun onBindViewHolder(holder: SearchResultsViewHolder, item: SearchSongViewModel, pos: Int) {
        holder.bind(item, onItemClick)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchResultsViewHolder {
        return SearchResultsViewHolder(
            parent.inflate(R.layout.item_search_result)
        )
    }
}