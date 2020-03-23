package com.soundapp.feature_commons.domain

class PlaylistInteractorImpl :
    PlaylistInteractor {

    override fun <T> preparePlayListFromItemSelected(item: T, list: ArrayList<T>): List<T> {
        list.remove(item)
        list.add(0, item)
        return list
    }
}