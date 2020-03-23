package com.soundapp.feature_search.main.data

import com.abecerra.base.data.BaseRepositoryImpl
import com.abecerra.base.utils.StringUtils.replaceSpacesBySymbol
import com.soundapp.database.dao.search.SearchesDao
import com.soundapp.database.entities.RecentSearchEntity
import com.soundapp.feature_commons.data.SongDtoMapper
import com.soundapp.feature_search.main.domain.repository.SearchRepository
import com.soundapp.feature_search.main.domain.repository.SearchRepositoryOutput
import com.soundapp.network.dto.ResponseDto
import com.soundapp.network.dto.SongDto
import com.soundapp.network.services.music.MusicService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchRepositoryImpl(
    private val musicService: MusicService,
    private val searchesDao: SearchesDao
) : BaseRepositoryImpl<SearchRepositoryOutput>(), SearchRepository {

    override fun doSearchCallWithTerm(term: String) {
        musicService.searchSongs(replaceSpacesBySymbol(term, API_SPACE_SYMBOL))
            .enqueue(object : Callback<ResponseDto<SongDto>> {
                override fun onResponse(
                    call: Call<ResponseDto<SongDto>>,
                    response: Response<ResponseDto<SongDto>>
                ) {
                    output?.onSearchResponse(
                        SongDtoMapper.mapToSong(response.body()?.results ?: arrayListOf())
                    )
                    searchesDao.addRecentSearch(RecentSearchEntity(term))
                }

                override fun onFailure(call: Call<ResponseDto<SongDto>>, t: Throwable) {
                    output?.onSearchResponse(emptyList())
                }
            })
    }

    override fun getRecentSearches() {
        searchesDao.findRecentSearches {
            output?.onRecentSearchesResponse(RecentSearchEntityMapper.map(it))
        }
    }

    override fun removeRecentSearch(term: String) {
        searchesDao.removeRecentSearch(term)
    }

    companion object {
        const val API_SPACE_SYMBOL = "+"
    }
}