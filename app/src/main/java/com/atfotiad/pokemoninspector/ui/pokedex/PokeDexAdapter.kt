package com.atfotiad.pokemoninspector.ui.pokedex

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.atfotiad.pokemoninspector.databinding.ItemPokeCardBinding
import com.atfotiad.pokemoninspector.model.Result

class PokeDexAdapter(private val items: List<Result>) : PagingDataAdapter<Result,PokeDexAdapter.MyViewHolder>(
    POKEMON_COMPARATOR) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            ItemPokeCardBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindView(items[position])

    }

    override fun getItemCount(): Int {
        return items.size
    }

    class MyViewHolder(private val rowBinding: ItemPokeCardBinding) : RecyclerView.ViewHolder(
        rowBinding.root
    ) {
        fun bindView(item: Result) {
            rowBinding.apply {
                name.text = item.name
            }
        }
    }
    companion object{
        private val POKEMON_COMPARATOR = object :DiffUtil.ItemCallback<Result>(){
            override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean =
                oldItem.name == newItem.name

            override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean =
                oldItem == newItem
        }
    }
}