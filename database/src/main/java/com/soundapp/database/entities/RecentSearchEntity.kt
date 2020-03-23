package com.soundapp.database.entities

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class RecentSearchEntity(
    @PrimaryKey
    open var searchText: String = ""
) : RealmObject()