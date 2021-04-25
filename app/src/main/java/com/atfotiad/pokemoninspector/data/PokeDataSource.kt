package com.atfotiad.pokemoninspector.data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.atfotiad.pokemoninspector.api.PokeApi
import com.atfotiad.pokemoninspector.api.BaseResponse

class PokeDataSource(
    private val pokeApi: PokeApi,
    private val query: String


) : PagingSource <String, BaseResponse>(){
    override suspend fun load(params: LoadParams<String>): LoadResult<String, BaseResponse> {
        TODO("Not yet implemented")
    }

    override fun getRefreshKey(state: PagingState<String, BaseResponse>): String? {
        TODO("Not yet implemented")
    }
}