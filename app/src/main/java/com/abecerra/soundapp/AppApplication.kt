package com.abecerra.soundapp

import androidx.multidex.MultiDexApplication
import io.realm.Realm

class AppApplication : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
        Realm.init(this)
    }

    companion object {
        private lateinit var INSTANCE: AppApplication

        fun getInstance(): AppApplication {
            return INSTANCE
        }
    }
}