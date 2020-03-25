package com.soundapp.database.dao.search

import com.soundapp.database.entities.RecentSearchEntity
import io.realm.Realm

class SearchesDaoImpl(private val realm: Realm) : SearchesDao {

    override fun addRecentSearch(search: RecentSearchEntity) {
        realm.executeTransactionAsync {
            it.insertOrUpdate(search)
        }
    }

    override fun findRecentSearches(success: (list: List<RecentSearchEntity>) -> Unit) {
        var searches: List<RecentSearchEntity> =
            realm.where(RecentSearchEntity::class.java).findAll().reversed()
        if (searches.size > 5) searches = searches.subList(0, 4)
        success(searches)
    }

    override fun removeRecentSearch(term: String) {
        realm.executeTransactionAsync {
            it.where(RecentSearchEntity::class.java).equalTo(SEARCH_TEXT_FIELD, term).findFirst()
                ?.deleteFromRealm()
        }
    }

    companion object {
        private const val SEARCH_TEXT_FIELD = "searchText"
    }
}