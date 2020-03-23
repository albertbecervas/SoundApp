package com.soundapp.feature_home.presentation.presenter

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.soundapp.feature_commons.presentation.model.SongViewModel
import com.soundapp.feature_home.presentation.model.SectionViewModel
import kotlinx.android.synthetic.main.item_home_section.view.*

class HomeSectionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val adapter: HomeSongAdapter = HomeSongAdapter {
        handleOnItemClick(it)
    }

    private var onItemClick: ((item: SongViewModel, list: ArrayList<SongViewModel>) -> Unit)? = null

    fun bind(
        sectionViewModel: SectionViewModel,
        onItemClick: (item: SongViewModel, list: ArrayList<SongViewModel>) -> Unit
    ) {
        this.onItemClick = onItemClick
        itemView.tv_section_title.text = sectionViewModel.sectionName
        itemView.rv_songs.layoutManager =
            LinearLayoutManager(itemView.context, RecyclerView.HORIZONTAL, false)
        itemView.rv_songs.adapter = adapter
        adapter.setItems(sectionViewModel.songs)
    }

    private fun handleOnItemClick(item: SongViewModel) {
        onItemClick?.invoke(item, adapter.getItems())
    }
}