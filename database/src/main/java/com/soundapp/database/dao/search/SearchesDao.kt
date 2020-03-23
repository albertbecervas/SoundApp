package com.soundapp.database.dao.search

import com.soundapp.database.entities.RecentSearchEntity

interface SearchesDao {

    fun addRecentSearch(search: RecentSearchEntity)

    fun findRecentSearches(success: (list: List<RecentSearchEntity>) -> Unit)

    fun removeRecentSearch(term: String)
}