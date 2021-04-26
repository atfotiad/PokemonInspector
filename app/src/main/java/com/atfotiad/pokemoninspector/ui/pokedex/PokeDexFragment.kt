package com.atfotiad.pokemoninspector.ui.pokedex

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.atfotiad.pokemoninspector.databinding.FragmentPokeDexBinding
import com.atfotiad.pokemoninspector.model.Result
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PokeDexFragment : Fragment() {
    private lateinit var binding: FragmentPokeDexBinding
    private lateinit var adapter: PokeDexAdapter
    private val results : List<Result> = ArrayList()
    private val viewModel by viewModels<PokeDexViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentPokeDexBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = PokeDexAdapter(results)
        binding.pokemonList.adapter = adapter

        viewModel.pokemons.observe(viewLifecycleOwner){
            adapter.submitData(viewLifecycleOwner.lifecycle,it)
        }



    }
}