package com.atfotiad.pokemoninspector.ui.pokedex

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.atfotiad.pokemoninspector.databinding.ItemPokeCardBinding
import com.atfotiad.pokemoninspector.model.Result

class PokeDexAdapter :
    PagingDataAdapter<Result, PokeDexAdapter.PokeViewHolder>(POKEMON_COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokeViewHolder {
        val binding =
            ItemPokeCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PokeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PokeViewHolder, position: Int) {
        val currentPokemon = getItem(position)
        if (currentPokemon != null) {
            holder.bind(currentPokemon)
        }
    }

    class PokeViewHolder(private val binding: ItemPokeCardBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(pokemon: Result) {
            binding.apply {
                name.text = pokemon.name
            }
        }

    }

    companion object {
        private val POKEMON_COMPARATOR = object : DiffUtil.ItemCallback<Result>() {
            override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean =
                oldItem.name == newItem.name

            override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean =
                oldItem == newItem
        }
    }

}


