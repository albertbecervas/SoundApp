package com.abecerra.soundapp.di.component

import com.abecerra.soundapp.di.module.data.GoogleAuthModule
import com.abecerra.soundapp.di.module.data.NetworkModule
import com.abecerra.soundapp.di.module.data.RepositoryModule
import com.abecerra.soundapp.di.module.data.SharedPreferencesModule
import com.abecerra.soundapp.di.module.domain.InteractorModule
import com.abecerra.soundapp.di.module.presentation.NavigationModule
import com.abecerra.soundapp.di.module.presentation.PresenterModule
import com.abecerra.soundapp.di.module.presentation.RouterModule
import com.abecerra.soundapp.di.module.presentation.ViewModule
import com.abecerra.soundapp.di.scope.PerApplication
import com.abecerra.soundapp.scenes.launcher.view.LauncherActivity
import com.abecerra.soundapp.scenes.main.view.MainActivity
import dagger.Component

@Component(
    modules = [ViewModule::class, PresenterModule::class, RouterModule::class,
        NavigationModule::class, InteractorModule::class, RepositoryModule::class,
        NetworkModule::class, SharedPreferencesModule::class, GoogleAuthModule::class]
)
@PerApplication
interface ViewComponent {

    fun inject(launcherActivity: LauncherActivity)
    fun inject(mainActivity: MainActivity)
}