package com.soundapp.feature_search.main.domain.model

data class SortOption(
    val id: Int,
    val optionName: String
) {
    companion object {
        const val PRICE: Int = 0
        const val DURATION: Int = 1
        const val GENRE: Int = 2
    }
}