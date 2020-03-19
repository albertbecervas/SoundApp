package com.abecerra.components.search

interface SearchComponentOutput {
    fun onSearch(text: String)
    fun emptySearch()
}