package com.soundapp.network.dto

data class ResponseDto<T>(
    val resultsCount: Any,
    val results: List<T>
)
