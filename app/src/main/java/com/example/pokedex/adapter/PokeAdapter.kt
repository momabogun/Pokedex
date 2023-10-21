package com.example.pokedex.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.pokedex.HomeFragmentDirections
import com.example.pokedex.R
import com.example.pokedex.data.model.Pokemon
import com.example.pokedex.databinding.ListItemBinding
import java.util.Locale

class PokeAdapter(
    val pokemonList: List<Pokemon>
) : RecyclerView.Adapter<PokeAdapter.PokemonViewHolder>() {

    inner class PokemonViewHolder(val binding: ListItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PokemonViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return pokemonList.size
    }

    //Fülle einen ViewHolder(layout: pokemon_item.xml) mit Inhalt(daten: Pokemon)
    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {

        val pokemon = pokemonList[position]
        Log.d("PokemonLog", "$pokemon")

        holder.binding.pokemonNameTV.text = pokemon.pokemonDb.name.split("-m").joinToString(" ♂").split("-f").joinToString(" ♀")


        {
            it.replaceFirstChar {
                if (it.isLowerCase()) it.titlecase(
                    Locale.ROOT
                ) else it.toString()
            }
        }
        holder.binding.pokemonIV.load(pokemon.pokemonDb.pokemonImage)

        holder.binding.number.text = if (pokemon.pokemonDb.id < 10) {
            "#000" + pokemon.pokemonDb.id.toString()
        } else if (pokemon.pokemonDb.id < 100) {
            "#00" + pokemon.pokemonDb.id.toString()
        } else {
            "#0" + pokemon.pokemonDb.id.toString()
        }




        holder.itemView.setOnClickListener {
            val navController = holder.itemView.findNavController()
            navController.navigate(
                HomeFragmentDirections.actionHomeFragmentToDetailsFragment(
                    pokemon.pokemonDb.id
                )
            )
        }

        holder.binding.type2IV.visibility = View.VISIBLE



        when (pokemon.types[0].name) {
            "fire" -> holder.binding.type1IV.setImageResource(R.drawable.fire_type_symbol_galar_by_jormxdos_dffvl1m)
            "grass" -> holder.binding.type1IV.setImageResource(R.drawable.grass_type_symbol_galar_by_jormxdos_dffvl0s)
            "normal" -> holder.binding.type1IV.setImageResource(R.drawable.normal_type_symbol_galar_by_jormxdos_dffvl62)
            "poison" -> holder.binding.type1IV.setImageResource(R.drawable.poison_type_symbol_galar_by_jormxdos_dffvl5p)
            "water" -> holder.binding.type1IV.setImageResource(R.drawable.water_type_symbol_galar_by_jormxdos_dffvl12)
            "rock" -> holder.binding.type1IV.setImageResource(R.drawable.rock_type_symbol_galar_by_jormxdos_dffvl3a)
            "fairy" -> holder.binding.type1IV.setImageResource(R.drawable.fairy_type_symbol_galar_by_jormxdos_dffvl2x)
            "bug" -> holder.binding.type1IV.setImageResource(R.drawable.bug_type_symbol_galar_by_jormxdos_dffvl73)
            "dark" -> holder.binding.type1IV.setImageResource(R.drawable.dark_type_symbol_galar_by_jormxdos_dffvl4c)
            "dragon" -> holder.binding.type1IV.setImageResource(R.drawable.dragon_type_symbol_galar_by_jormxdos_dffvl4n)
            "fighting" -> holder.binding.type1IV.setImageResource(R.drawable.fighting_type_symbol_galar_by_jormxdos_dffvl1w)
            "ghost" -> holder.binding.type1IV.setImageResource(R.drawable.ghost_type_symbol_galar_by_jormxdos_dffvl2d)
            "flying" -> holder.binding.type1IV.setImageResource(R.drawable.flying_type_symbol_galar_by_jormxdos_dffvl6n)
            "ground" -> holder.binding.type1IV.setImageResource(R.drawable.ground_type_symbol_galar_by_jormxdos_dffvl6w)
            "ice" -> holder.binding.type1IV.setImageResource(R.drawable.ice_type_symbol_galar_by_jormxdos_dffvl40)
            "psychic" -> holder.binding.type1IV.setImageResource(R.drawable.psychic_type_symbol_galar_by_jormxdos_dffvl5b)
            "steel" -> holder.binding.type1IV.setImageResource(R.drawable.steel_type_symbol_galar_by_jormxdos_dffvl50)
            "electric" -> holder.binding.type1IV.setImageResource(R.drawable.electric_type_symbol_galar_by_jormxdos_dffvl6b)
        }

        if (pokemon.types.size > 1) {
            when (pokemon.types[1].name) {
                "fire" -> holder.binding.type2IV.setImageResource(R.drawable.fire_type_symbol_galar_by_jormxdos_dffvl1m)
                "grass" -> holder.binding.type2IV.setImageResource(R.drawable.grass_type_symbol_galar_by_jormxdos_dffvl0s)
                "normal" -> holder.binding.type2IV.setImageResource(R.drawable.normal_type_symbol_galar_by_jormxdos_dffvl62)
                "poison" -> holder.binding.type2IV.setImageResource(R.drawable.poison_type_symbol_galar_by_jormxdos_dffvl5p)
                "water" -> holder.binding.type2IV.setImageResource(R.drawable.water_type_symbol_galar_by_jormxdos_dffvl12)
                "rock" -> holder.binding.type2IV.setImageResource(R.drawable.rock_type_symbol_galar_by_jormxdos_dffvl3a)
                "fairy" -> holder.binding.type2IV.setImageResource(R.drawable.fairy_type_symbol_galar_by_jormxdos_dffvl2x)
                "bug" -> holder.binding.type2IV.setImageResource(R.drawable.bug_type_symbol_galar_by_jormxdos_dffvl73)
                "dark" -> holder.binding.type2IV.setImageResource(R.drawable.dark_type_symbol_galar_by_jormxdos_dffvl4c)
                "dragon" -> holder.binding.type2IV.setImageResource(R.drawable.dragon_type_symbol_galar_by_jormxdos_dffvl4n)
                "fighting" -> holder.binding.type2IV.setImageResource(R.drawable.fighting_type_symbol_galar_by_jormxdos_dffvl1w)
                "ghost" -> holder.binding.type2IV.setImageResource(R.drawable.ghost_type_symbol_galar_by_jormxdos_dffvl2d)
                "flying" -> holder.binding.type2IV.setImageResource(R.drawable.flying_type_symbol_galar_by_jormxdos_dffvl6n)
                "ground" -> holder.binding.type2IV.setImageResource(R.drawable.ground_type_symbol_galar_by_jormxdos_dffvl6w)
                "ice" -> holder.binding.type2IV.setImageResource(R.drawable.ice_type_symbol_galar_by_jormxdos_dffvl40)
                "psychic" -> holder.binding.type2IV.setImageResource(R.drawable.psychic_type_symbol_galar_by_jormxdos_dffvl5b)
                "steel" -> holder.binding.type2IV.setImageResource(R.drawable.steel_type_symbol_galar_by_jormxdos_dffvl50)
                "electric" -> holder.binding.type1IV.setImageResource(R.drawable.electric_type_symbol_galar_by_jormxdos_dffvl6b)
            }


        } else{
            holder.binding.type2IV.visibility = View.GONE

        }
    }


    }



