package com.atfotiad.pokemoninspector.ui.pokedex

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.atfotiad.pokemoninspector.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PokeDexFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_poke_dex, container, false)
    }



}