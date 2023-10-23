package com.example.pokedex

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import coil.load
import com.example.pokedex.adapter.MovesAdapter
import com.example.pokedex.adapter.StatsAdapter
import com.example.pokedex.data.model.Pokemon
import com.example.pokedex.data.model.pokemonAbilities.PokemonAbility
import com.example.pokedex.data.model.pokemonType.PokemonType
import com.example.pokedex.databinding.FragmentDetailsBinding
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




    @SuppressLint("SetTextI18n")
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

        fun showStats() {

        }




        viewmodel.getPokemon(pokeId).observe(viewLifecycleOwner) {
            pokemon = it
            binding.detailsIV.load(pokemon.pokemonDb.pokemonImage)
            binding.detailsTitleTV.text = pokemon.pokemonDb.name.replaceFirstChar {
                if (it.isLowerCase()) it.titlecase(
                    Locale.ROOT
                ) else it.toString()
            }

            binding.detailsIdTV.text = if (pokemon.pokemonDb.id < 10) {
                "#000" + pokemon.pokemonDb.id.toString()
            } else if (pokemon.pokemonDb.id < 100) {
                "#00" + pokemon.pokemonDb.id.toString()
            } else {
                "#0" + pokemon.pokemonDb.id.toString()
            }
            binding.backBTN.setOnClickListener {
                findNavController().navigateUp()
            }









            val statAdapter = StatsAdapter(it.stats, it.nameStats)
            binding.statsRV.adapter = statAdapter





            val adapter = MovesAdapter(it.moves.toMutableList(), it.levels.toMutableList())
            binding.movesRV.adapter = adapter


            viewmodel.getEvolution(it.pokemonDb.evolution).observe(viewLifecycleOwner){

                if (it.levelToEvolve == 0){
                    binding.evolutionFL.visibility = View.GONE
                } else{
                    binding.textView8.text = it.basicName
                    binding.textView9.text = it.firstEvoName
                    binding.lvlDetailsTV.text = it.levelToEvolve.toString()
                    binding.evolution1IV.load(it.basicPicture)
                    binding.evolution2IV.load(it.firstEvoPicture)
                }

                if (it.levelToEvolveSecond == 0){
                    binding.textView10.text = ""
                    binding.textView11.text = ""
                    binding.lvlDetails2TV.text= ""
                    binding.arrow2IV.visibility = View.GONE
                    binding.evolution12IV.visibility = View.GONE
                    binding.evolution22IV.visibility = View.GONE
                }else{
                    binding.textView10.text = it.firstEvoName
                    binding.textView11.text = it.secondEvoName
                    binding.lvlDetails2TV.text = it.levelToEvolveSecond.toString()
                    binding.evolution12IV.load(it.firstEvoPicture)
                    binding.evolution22IV.load(it.secondEvoPicture)

                }






            }





            val typesList: List<PokemonType> = pokemon.types
            val type1 = typesList[0].name


            binding.typeDetailsTV.text = type1.replaceFirstChar {
                if (it.isLowerCase()) it.titlecase(
                    Locale.ROOT
                ) else it.toString()
            }

            if (pokemon.types.size > 1) {
                val type2 = typesList[1].name
                binding.typeDetails2TV.text = type2.replaceFirstChar {
                    if (it.isLowerCase()) it.titlecase(
                        Locale.ROOT
                    ) else it.toString()
                }
            } else {
                binding.typeDetails2TV.visibility = View.GONE
            }

            val abilityList: List<PokemonAbility> = pokemon.abilities
            val abilityNameList: MutableList<String> = mutableListOf()
            for (ability in abilityList) {
                abilityNameList.add(ability.name.split("-").joinToString(" ") {
                    it.replaceFirstChar {
                        if (it.isLowerCase()) it.titlecase(
                            Locale.ROOT
                        ) else it.toString()
                    }
                })
            }
            binding.abilityTV.text = abilityNameList.joinToString(", ")

            binding.habitatTV.text = pokemon.pokemonDb.habitat.replaceFirstChar {
                if (it.isLowerCase()) it.titlecase(
                    Locale.ROOT
                ) else it.toString()
            }

            binding.aboutTextTV.text = pokemon.pokemonDb.aboutText

            binding.heightTV.text = (pokemon.pokemonDb.height * 10).toString() + " cm"

            binding.weightTV.text = (pokemon.pokemonDb.weight / 10.0).toString() + " kg"

            binding.generationTV.text = pokemon.pokemonDb.generation.split("-").joinToString(" ") {
                it.replaceFirstChar {
                    if (it.isLowerCase()) it.titlecase(
                        Locale.ROOT
                    ) else it.toString()
                }
            }






            when (type1) {
                "fire" -> {
                    binding.backgroundIV.setImageResource(R.drawable.fire_type_pokemon_go_wallpaper___qhd___by_elbarnzo_dfrc8g2)

                }

                "grass" -> {
                    binding.backgroundIV.setImageResource(R.drawable.grass_type_pokemon_go_wallpaper___qhd___by_elbarnzo_dfqwup7)
                }

                "normal" -> {
                    binding.backgroundIV.setImageResource(R.drawable.normal_type_pokemon_go_wallpaper___qhd___by_elbarnzo_dfqn3ht)
                }

                "poison" -> {
                    binding.backgroundIV.setImageResource(R.drawable.poison_type_pokemon_go_wallpaper___qhd___by_elbarnzo_dfqkyl8)
                }

                "water" -> {
                    binding.backgroundIV.setImageResource(R.drawable.water_type_pokemon_go_wallpaper___qhd___by_elbarnzo_dfq8w8w)
                }

                "rock" -> {
                    binding.backgroundIV.setImageResource(R.drawable.rock_type_pokemon_go_wallpaper___qhd___by_elbarnzo_dfqdk3v)
                }

                "fairy" -> {
                    binding.backgroundIV.setImageResource(R.drawable.fairy_type_pokemon_go_wallpaper___qhd___by_elbarnzo_dfrlafa)
                }

                "bug" -> {
                    binding.backgroundIV.setImageResource(R.drawable.bug_type_pokemon_go_wallpaper___qhd___by_elbarnzo_dfsf928)
                }

                "dark" -> {
                    binding.backgroundIV.setImageResource(R.drawable.dark_type_pokemon_go_wallpaper___qhd___by_elbarnzo_dfrxgkx)
                }

                "dragon" -> {
                    binding.backgroundIV.setImageResource(R.drawable.dragon_type_pokemon_go_wallpaper___qhd___by_elbarnzo_dfruokc)
                }

                "fighting" -> {
                    binding.backgroundIV.setImageResource(R.drawable.fighting_type_pokemon_go_wallpaper___qhd___by_elbarnzo_dfrf41z)
                }

                "ghost" -> {
                    binding.backgroundIV.setImageResource(R.drawable.ghost_type_pokemon_go_wallpaper___qhd___by_elbarnzo_dfr2x1c)
                }

                "flying" -> {
                    binding.backgroundIV.setImageResource(R.drawable.flying_type_pokemon_go_wallpaper___qhd___by_elbarnzo_dfr8yz4)
                }

                "ground" -> {
                    binding.backgroundIV.setImageResource(R.drawable.ground_type_pokemon_go_wallpaper___qhd___by_elbarnzo_dfqt8yd)
                }

                "ice" -> {
                    binding.backgroundIV.setImageResource(R.drawable.ice_type_pokemon_go_wallpaper___qhd___by_elbarnzo_dfqpn6x)
                }

                "psychic" -> {
                    binding.backgroundIV.setImageResource(R.drawable.psychic_type_pokemon_go_wallpaper___qhd___by_elbarnzo_dfqh5to)
                }

                "steel" -> {
                    binding.backgroundIV.setImageResource(R.drawable.steel_type_pokemon_go_wallpaper___qhd___by_elbarnzo_dfqbr77)
                }

                "electric" -> {
                    binding.backgroundIV.setImageResource(R.drawable.electric_type_pokemon_go_wallpaper___qhd___by_elbarnzo_dfrnwtw)
                }
            }
        }



        binding.movesRV.visibility = View.GONE
        binding.tableRow.visibility = View.GONE
        binding.evolutionFL.visibility = View.GONE



        binding.scrollAbout.visibility = View.VISIBLE


        binding.radioGroup.setOnCheckedChangeListener { _, i ->
            when (i) {
                R.id.rbAbout -> {
                    binding.movesRV.visibility = View.GONE
                    binding.tableRow.visibility = View.GONE
                    binding.scrollAbout.visibility = View.VISIBLE
                    binding.statsRV.visibility = View.GONE
                    binding.evolutionFL.visibility = View.GONE
                }

                R.id.rbStats -> {
                    binding.movesRV.visibility = View.GONE
                    binding.tableRow.visibility = View.GONE
                    binding.scrollAbout.visibility = View.GONE
                    binding.statsRV.visibility = View.VISIBLE
                    binding.evolutionFL.visibility = View.GONE
                }

                R.id.rbEvolution -> {
                    binding.movesRV.visibility = View.GONE
                    binding.tableRow.visibility = View.GONE
                    binding.scrollAbout.visibility = View.GONE
                    binding.statsRV.visibility = View.GONE
                    binding.evolutionFL.visibility = View.VISIBLE
                }

                R.id.rbMoves -> {
                    binding.movesRV.visibility = View.VISIBLE
                    binding.scrollAbout.visibility = View.GONE
                    binding.tableRow.visibility = View.VISIBLE
                    binding.statsRV.visibility = View.GONE
                    binding.evolutionFL.visibility = View.GONE
                }
            }
        }


    }


}