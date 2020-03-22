package com.soundapp.feature_home.presentation.presenter

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.soundapp.feature_home.presentation.model.SectionViewModel
import kotlinx.android.synthetic.main.item_home_section.view.*

class HomeSectionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val adapter: HomeSongAdapter = HomeSongAdapter()

    fun bind(sectionViewModel: SectionViewModel) {
        itemView.tv_section_title.text = sectionViewModel.sectionName
        itemView.rv_songs.layoutManager =
            LinearLayoutManager(itemView.context, RecyclerView.HORIZONTAL, false)
        itemView.rv_songs.adapter = adapter
        adapter.setItems(sectionViewModel.songs)
    }
}