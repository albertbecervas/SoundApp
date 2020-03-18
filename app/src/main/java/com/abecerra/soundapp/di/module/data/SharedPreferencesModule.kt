package com.abecerra.soundapp.di.module.data

import android.content.Context
import com.soundapp.session.user.data.UserDataSource
import com.soundapp.session.user.data.UserSharedPreferences
import dagger.Module
import dagger.Provides

@Module
class SharedPreferencesModule {

    @Provides
    fun provideUserSharedPreferences(context: Context): UserDataSource {
        return UserSharedPreferences(context)
    }
}