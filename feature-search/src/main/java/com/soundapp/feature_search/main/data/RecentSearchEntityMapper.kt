package com.soundapp.feature_search.main.data

import com.soundapp.database.entities.RecentSearchEntity
import com.soundapp.feature_search.main.domain.model.RecentSearch

object RecentSearchEntityMapper {

    fun map(from: List<RecentSearchEntity>): List<RecentSearch> {
        return from.map { map(it) }
    }

    private fun map(from: RecentSearchEntity): RecentSearch {
        return RecentSearch(from.searchText)
    }
}