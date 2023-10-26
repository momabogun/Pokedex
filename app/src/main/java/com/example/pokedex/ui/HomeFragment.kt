package com.example.pokedex.ui

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.pokedex.PokeViewModel
import com.example.pokedex.adapter.PokeAdapter
import com.example.pokedex.databinding.FragmentHomeBinding
import java.util.Locale

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val viewmodel: PokeViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)







        val adapter = PokeAdapter(emptyList())
        binding.pokeRV.adapter = adapter


        viewmodel.pokemon.observe(viewLifecycleOwner) {
            adapter.newData(it)

        }



        binding.searchView.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {}

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val query = s.toString()
                if (query.isNotEmpty()) {
                    val filteredList = viewmodel.pokemon.value?.filter { pokemon ->
                        pokemon.pokemonDb.name.lowercase(Locale.ROOT).contains(query)

                    }
                    if (filteredList != null) {
                        adapter.newData(filteredList)
                    }

                } else {
                    viewmodel.pokemon.value?.let { adapter.newData(it) }
                }

            }


        })
    }










}