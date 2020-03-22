package com.soundapp.feature_home.presentation.presenter

import android.view.ViewGroup
import com.abecerra.base.presentation.BaseAdapter
import com.abecerra.base.utils.inflate
import com.soundapp.feature_home.R
import com.soundapp.feature_commons.presentation.model.SongViewModel

class HomeSongAdapter : BaseAdapter<HomeSongViewHolder, SongViewModel>() {
    override fun onBindViewHolder(holder: HomeSongViewHolder, item: SongViewModel, pos: Int) {
        holder.bind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeSongViewHolder {
        return HomeSongViewHolder(parent.inflate(R.layout.item_home_song))
    }
}