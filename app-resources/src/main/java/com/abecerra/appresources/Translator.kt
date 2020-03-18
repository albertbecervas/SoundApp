package com.abecerra.appresources

import android.content.Context

class Translator(private val appContext: Context) {

    fun getString(int: Int): String = appContext.getString(int)

}