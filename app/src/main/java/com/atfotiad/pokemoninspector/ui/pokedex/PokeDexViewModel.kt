package com.atfotiad.pokemoninspector.ui.pokedex

import androidx.lifecycle.ViewModel
import com.atfotiad.pokemoninspector.data.PokeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PokeDexViewModel @Inject constructor(private val repository: PokeRepository) : ViewModel() {
}