package com.example.pokedex

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.pokedex.adapter.GenAdapter
import com.example.pokedex.adapter.PokeAdapter
import com.example.pokedex.data.LocalRepository
import com.example.pokedex.data.model.Pokemon
import com.example.pokedex.databinding.FragmentHomeBinding
import com.example.pokedex.databinding.FragmentPokedexBinding


class PokedexFragment : Fragment() {


    private lateinit var binding: FragmentPokedexBinding




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentPokedexBinding.inflate(layoutInflater, container, false)
        return binding.root
    }




    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val gen = LocalRepository().generationList()
        binding.generationRV.adapter = GenAdapter(gen)


    }




}