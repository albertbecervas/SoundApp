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
        realm.executeTransactionAsync {
            val searches = it.where(RecentSearchEntity::class.java).findAll()
            success(searches)
        }
    }

    override fun removeRecentSearch(term: String) {
        realm.executeTransactionAsync {
            it.where(RecentSearchEntity::class.java).equalTo("searchText", term).findFirst()
                ?.deleteFromRealm()
        }
    }
}