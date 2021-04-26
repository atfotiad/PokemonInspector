package com.atfotiad.pokemoninspector.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.atfotiad.pokemoninspector.api.PokeApi
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PokeRepository @Inject constructor(private val pokeApi: PokeApi) {

    fun getPokeResults() =
        Pager(
            config = PagingConfig(
                pageSize = loadSize,
            enablePlaceholders = false),
            pagingSourceFactory = {PokeDataSource(pokeApi)}
        ).liveData

}