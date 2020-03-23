package com.soundapp.feature_search.suggestions.view

import android.view.ViewGroup
import com.abecerra.base.presentation.BaseAdapter
import com.abecerra.base.utils.inflate
import com.soundapp.feature_search.R
import com.soundapp.feature_search.main.domain.model.SearchSuggestion

class SearchSuggestionsAdapter(private val onItemSelected: (name: String) -> Unit) :
    BaseAdapter<SearchSuggestionsViewHolder, SearchSuggestion>() {
    override fun onBindViewHolder(
        holder: SearchSuggestionsViewHolder, item: SearchSuggestion, pos: Int
    ) {
        holder.bind(item, onItemSelected)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchSuggestionsViewHolder {
        return SearchSuggestionsViewHolder(parent.inflate(R.layout.item_search_suggestion))
    }
}