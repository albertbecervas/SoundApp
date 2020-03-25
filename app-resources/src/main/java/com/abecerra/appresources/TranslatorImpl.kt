package com.abecerra.appresources

import android.content.Context

class TranslatorImpl(private val appContext: Context) : Translator {

    override fun getString(int: Int): String = appContext.getString(int)
}