package com.soundapp.feature_home.data

import com.abecerra.base.data.BaseRepositoryImpl
import com.soundapp.feature_home.domain.repository.HomeRepository
import com.soundapp.feature_home.domain.repository.HomeRepositoryOutput
import com.soundapp.network.music.MusicService

class HomeRepositoryImpl(private val musicService: MusicService) :
    BaseRepositoryImpl<HomeRepositoryOutput>(), HomeRepository {
}