package com.soundapp.feature_search.suggestions.view

import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.soundapp.feature_search.main.domain.model.SearchSuggestion
import kotlinx.android.synthetic.main.item_search_suggestion.view.*

class SearchSuggestionsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(
        searchSuggestionModel: SearchSuggestion,
        onItemSelected: (name: String) -> Unit
    ) {
        itemView.tv_genre_type.text = searchSuggestionModel.name
        itemView.cv_suggestion.setCardBackgroundColor(
            ContextCompat.getColor(itemView.context, searchSuggestionModel.color)
        )
        itemView.setOnClickListener {
            onItemSelected(searchSuggestionModel.name)
        }
    }
}