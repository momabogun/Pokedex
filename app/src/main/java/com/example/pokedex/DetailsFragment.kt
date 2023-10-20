package com.example.pokedex

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import coil.load
import com.example.pokedex.adapter.MovesAdapter
import com.example.pokedex.data.model.Move
import com.example.pokedex.data.model.Pokemon
import com.example.pokedex.data.model.PokemonDb
import com.example.pokedex.databinding.FragmentDetailsBinding
import kotlinx.coroutines.flow.combine
import java.util.Locale



class DetailsFragment : Fragment() {


    private lateinit var binding: FragmentDetailsBinding
    private val viewmodel: PokeViewModel by activityViewModels()

    private var pokeId: Int = 0
    private lateinit var pokemon: Pokemon
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        arguments?.let { it ->
            pokeId = it.getInt("pokeId")

        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        fun showAbout() {
            binding.movesRV.visibility = TextView.GONE
        }

        fun showMoves() {
            binding.movesRV.visibility = TextView.VISIBLE
        }

        fun showEvolution() {
            binding.movesRV.visibility = TextView.GONE
        }

        fun showStats(){

        }

        viewmodel.getPokemon(pokeId).observe(viewLifecycleOwner){
            pokemon = it
            binding.detailsIV.load(pokemon.pokemonDb.pokemonImage)
            binding.detailsTitleTV.text= pokemon.pokemonDb.name.replaceFirstChar {
                if (it.isLowerCase()) it.titlecase(
                    Locale.ROOT
                ) else it.toString()
            }

            binding.detailsIdTV.text = if (pokemon.pokemonDb.id < 10){
                "#000" + pokemon.pokemonDb.id.toString()
            } else if(pokemon.pokemonDb.id < 100) {
                "#00" + pokemon.pokemonDb.id.toString()
            } else {
                "#0" + pokemon.pokemonDb.id.toString()
            }
            binding.backBTN.setOnClickListener {
                findNavController().navigateUp()
            }

            val adapter = MovesAdapter(it.moves.toMutableList(),it.levels.toMutableList())
            binding.movesRV.adapter = adapter






        }

        binding.movesRV.visibility = View.GONE







        binding.radioGroup.setOnCheckedChangeListener { _, i ->
            when(i){
                R.id.rbAbout -> binding.movesRV.visibility = View.GONE
                R.id.rbStats -> binding.movesRV.visibility = View.GONE
                R.id.rbEvolution -> binding.movesRV.visibility = View.GONE
                R.id.rbMoves -> binding.movesRV.visibility = View.VISIBLE
            }
        }








    }


}