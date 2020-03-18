package com.abecerra.soundapp.di.module.data

import com.soundapp.network.BuildConfig
import com.soundapp.network.services.authentication.AuthService
import com.soundapp.network.services.authentication.AuthServiceImpl
import com.soundapp.network.services.music.MusicService
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

@Module
class NetworkModule {

    @Provides
    fun provideMoshiConverter(): MoshiConverterFactory {
        return MoshiConverterFactory.create()
    }

    @Provides
    fun provideRetrofit(moshiConverterFactory: MoshiConverterFactory): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.API_URL)
            .addConverterFactory(moshiConverterFactory)
            .build()
    }

    @Provides
    fun provideUserService(): AuthService {
        return AuthServiceImpl()
    }

    @Provides
    fun provideMusicService(retrofit: Retrofit): MusicService {
        return retrofit.create(MusicService::class.java)
    }
}