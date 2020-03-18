package com.abecerra.soundapp.di.module.presentation

import com.abecerra.soundapp.navigation.navigator.Navigator
import com.abecerra.soundapp.navigation.routers.HomeRouterImpl
import com.abecerra.soundapp.navigation.routers.LauncherRouterImpl
import com.abecerra.soundapp.navigation.routers.LoginRouterImpl
import com.abecerra.soundapp.navigation.routers.MainRouterImpl
import com.abecerra.soundapp.scenes.launcher.router.LauncherRouter
import com.abecerra.soundapp.scenes.main.router.MainRouter
import com.soundapp.feature_home.presentation.router.HomeRouter
import com.soundapp.feature_home.presentation.view.HomeFragment
import com.soundapp.session.login.router.LoginRouter
import com.soundapp.session.login.view.LoginFragment
import dagger.Module
import dagger.Provides

@Module
class RouterModule {

    @Provides
    fun provideLauncherRouter(navigator: Navigator, loginFragment: LoginFragment): LauncherRouter {
        return LauncherRouterImpl(navigator, loginFragment)
    }

    @Provides
    fun provideMainRouter(navigator: Navigator, homeFragment: HomeFragment): MainRouter {
        return MainRouterImpl(navigator, homeFragment)
    }

    @Provides
    fun provideLoginRouter(navigator: Navigator): LoginRouter {
        return LoginRouterImpl(navigator)
    }

    @Provides
    fun provideHomeRouter(navigator: Navigator): HomeRouter {
        return HomeRouterImpl(navigator)
    }
}