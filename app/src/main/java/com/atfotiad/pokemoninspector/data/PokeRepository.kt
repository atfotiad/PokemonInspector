package com.atfotiad.pokemoninspector.data

import com.atfotiad.pokemoninspector.api.PokeApi
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PokeRepository @Inject constructor(private val pokeApi: PokeApi) {

}