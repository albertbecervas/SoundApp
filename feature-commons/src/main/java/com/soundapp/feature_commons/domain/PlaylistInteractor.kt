package com.soundapp.feature_commons.domain

interface PlaylistInteractor {
    fun <T> preparePlayListFromItemSelected(item: T, list: ArrayList<T>): List<T>
}