package com.soundapp.feature_search.suggestions.view

import android.view.View
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.RecyclerView
import com.soundapp.feature_search.suggestions.model.SearchSuggestionViewModel
import kotlinx.android.synthetic.main.item_search_suggestion.view.*

class SearchSuggestionsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(
        searchSuggestionViewModel: SearchSuggestionViewModel,
        onItemSelected: (name: String) -> Unit
    ) {
        itemView.tv_genre_type.text = searchSuggestionViewModel.name
        itemView.cv_suggestion.setCardBackgroundColor(
            ContextCompat.getColor(itemView.context, searchSuggestionViewModel.color)
        )
        itemView.setOnClickListener {
            onItemSelected(searchSuggestionViewModel.name)
        }
    }
}