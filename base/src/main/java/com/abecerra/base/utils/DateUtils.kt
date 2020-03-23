package com.abecerra.base.utils

import java.text.SimpleDateFormat
import java.util.*

fun String.formatDate(): String {
    val fromDateFormat = SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss'Z'", Locale.ENGLISH)
    val toDateFormat = SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH)
    return try {
        fromDateFormat.parse(this)?.let {
            toDateFormat.format(it)
        } ?: ""
    } catch (e: Exception) {
        ""
    }
}

fun Double.formatTime(): String {
    val fromDateFormat = SimpleDateFormat("mm:ss", Locale.ENGLISH)
    return try {
        fromDateFormat.format(Date(this.toLong()))
    } catch (e: Exception) {
        ""
    }
}