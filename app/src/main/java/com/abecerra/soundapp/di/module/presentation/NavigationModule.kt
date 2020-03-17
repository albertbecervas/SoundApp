package com.abecerra.soundapp.di.module.presentation

import android.content.Context
import com.abecerra.soundapp.navigation.navigator.Navigator
import com.abecerra.soundapp.navigation.navigator.NavigatorImpl
import dagger.Module
import dagger.Provides
import java.lang.ref.WeakReference

@Module
class NavigationModule {

    @Provides
    fun provideNavigator(context: Context?): Navigator {
        return NavigatorImpl(WeakReference(context))
    }
}