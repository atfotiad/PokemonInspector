package com.atfotiad.pokemoninspector.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PokeApi {

    @GET("pokemon")
    suspend fun getAllPokemon(
            @Query("offset")
            offset: Int = 0,
            @Query("limit")
            limit: Int = 100): Response<BaseResponse>


}