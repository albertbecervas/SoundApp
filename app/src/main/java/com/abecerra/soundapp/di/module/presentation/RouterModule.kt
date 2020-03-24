package com.abecerra.soundapp.di.module.presentation

import com.abecerra.soundapp.navigation.navigator.Navigator
import com.abecerra.soundapp.navigation.routers.*
import com.abecerra.soundapp.scenes.launcher.router.LauncherRouter
import com.abecerra.soundapp.scenes.main.router.MainRouter
import com.soundapp.feature_home.presentation.router.HomeRouter
import com.soundapp.feature_home.presentation.view.HomeFragment
import com.soundapp.feature_profile.router.ProfileDialogRouter
import com.soundapp.feature_profile.view.ProfileDialogFragment
import com.soundapp.feature_search.main.presentation.router.SearchRouter
import com.soundapp.feature_search.main.presentation.view.SearchFragment
import com.soundapp.session.login.router.LoginRouter
import com.soundapp.session.login.view.LoginFragment
import com.soundapp.session.signup.router.SignUpRouter
import com.soundapp.session.signup.view.SignUpFragment
import dagger.Module
import dagger.Provides

@Module
class RouterModule {

    @Provides
    fun provideLauncherRouter(navigator: Navigator, loginFragment: LoginFragment): LauncherRouter {
        return LauncherRouterImpl(navigator, loginFragment)
    }

    @Provides
    fun provideMainRouter(
        navigator: Navigator,
        homeFragment: HomeFragment,
        searchFragment: SearchFragment,
        profileFragment: ProfileDialogFragment
    ): MainRouter {
        return MainRouterImpl(navigator, homeFragment, searchFragment, profileFragment)
    }

    @Provides
    fun provideLoginRouter(navigator: Navigator, signUpFragment: SignUpFragment): LoginRouter {
        return LoginRouterImpl(navigator, signUpFragment)
    }

    @Provides
    fun provideSignUpRouter(navigator: Navigator): SignUpRouter {
        return SignUpRouterImpl(navigator)
    }

    @Provides
    fun provideHomeRouter(navigator: Navigator): HomeRouter {
        return HomeRouterImpl(navigator)
    }

    @Provides
    fun provideSearchRouter(
        navigator: Navigator
    ): SearchRouter {
        return SearchRouterImpl(navigator)
    }

    @Provides
    fun provideProfileRouter(navigator: Navigator): ProfileDialogRouter {
        return ProfileDialogRouterImpl(navigator)
    }
}