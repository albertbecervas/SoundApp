package com.abecerra.base.utils

object StringUtils {

    const val EMPTY_STRING = ""
    const val SPACE = " "

    fun replaceSpacesBySymbol(text: String, symbol: String): String {
        return text.replace(SPACE, symbol)
    }
}