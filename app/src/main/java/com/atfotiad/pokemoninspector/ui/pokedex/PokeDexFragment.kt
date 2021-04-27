package com.atfotiad.pokemoninspector.ui.pokedex

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.atfotiad.pokemoninspector.R
import com.atfotiad.pokemoninspector.databinding.FragmentPokeDexBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PokeDexFragment : Fragment(R.layout.fragment_poke_dex) {
    private var _binding: FragmentPokeDexBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: PokeDexAdapter
    private val viewModel by viewModels<PokeDexViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentPokeDexBinding.bind(view)

        adapter = PokeDexAdapter()
        binding.pokemonList.adapter = adapter

        viewModel.pokemons.observe(viewLifecycleOwner) {
            adapter.submitData(viewLifecycleOwner.lifecycle, it)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}