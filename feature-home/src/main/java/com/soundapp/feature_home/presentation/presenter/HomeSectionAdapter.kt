package com.soundapp.feature_home.presentation.presenter

import android.view.ViewGroup
import com.abecerra.base.presentation.BaseAdapter
import com.abecerra.base.utils.inflate
import com.soundapp.feature_commons.presentation.model.SongViewModel
import com.soundapp.feature_home.R
import com.soundapp.feature_home.presentation.model.SectionViewModel

class HomeSectionAdapter(
    private val onItemClick: (item: SongViewModel, list: ArrayList<SongViewModel>) -> Unit
) :
    BaseAdapter<HomeSectionViewHolder, SectionViewModel>() {
    override fun onBindViewHolder(holder: HomeSectionViewHolder, item: SectionViewModel, pos: Int) {
        holder.bind(item, onItemClick)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeSectionViewHolder {
        return HomeSectionViewHolder(parent.inflate(R.layout.item_home_section))
    }
}