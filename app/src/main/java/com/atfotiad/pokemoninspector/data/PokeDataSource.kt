package com.atfotiad.pokemoninspector.data

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.atfotiad.pokemoninspector.api.PokeApi
import com.atfotiad.pokemoninspector.model.Result
import retrofit2.HttpException
import java.io.IOException

internal const val loadSize = 20
private val INITIAL_POKE_PAGE_INDEX = PagingIndex(limit = loadSize, offset = 0, total = 0)

class PokeDataSource(
    private val pokeApi: PokeApi,


) : PagingSource<PagingIndex, Result>() {
    override suspend fun load(params: LoadParams<PagingIndex>): LoadResult<PagingIndex, Result> {
        val limit = params.key?.limit ?: INITIAL_POKE_PAGE_INDEX.limit
        val offset = params.key?.offset ?: INITIAL_POKE_PAGE_INDEX.offset

        return try {
            val response = pokeApi.getAllPokemon(offset, limit)
            val pokemonList = response.body()?.results ?: ArrayList()
            for (pokemon :Result in pokemonList){
                Log.d("pokemonList", "load: "+ (pokemon.name ))
            }


            val (previousKey, nextKey) = INITIAL_POKE_PAGE_INDEX.pagingIndexing(
                offset = offset,
                totalFromServer = response.body()!!.count,
                totalFromPaging = params.key?.total ?: 0
            )

            LoadResult.Page(
                data = pokemonList,
                prevKey = previousKey,
                nextKey = nextKey
            )

        } catch (exception: IOException) {
            return LoadResult.Error(exception)
        } catch (exception: HttpException) {
            return LoadResult.Error(exception)
        }
    }

    override fun getRefreshKey(state: PagingState<PagingIndex, Result>): PagingIndex? {
        TODO("Not yet implemented")
    }

}