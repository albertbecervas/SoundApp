package com.soundapp.feature_search.main.presentation.model

import com.abecerra.components.filter.SortComponentViewModel
import com.soundapp.feature_search.main.domain.model.SortOption

object SortViewModelMapper {

    fun map(from: List<SortOption>): List<SortComponentViewModel> {
        return from.map { map(it) }
    }

    private fun map(from: SortOption): SortComponentViewModel {
        return SortComponentViewModel(from.optionName, from.id)
    }
}