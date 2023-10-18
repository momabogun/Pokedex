package com.example.pokedex.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.pokedex.data.model.Pokemon
import com.example.pokedex.databinding.ListItemBinding
import java.util.Locale

class PokeAdapter(
    val pokemonList: List<Pokemon>,
) : RecyclerView.Adapter<PokeAdapter.PokemonViewHolder>() {

    inner class PokemonViewHolder(val binding: ListItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return PokemonViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return pokemonList.size
    }

    //Fülle einen ViewHolder(layout: pokemon_item.xml) mit Inhalt(daten: Pokemon)
    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {

        val pokemon = pokemonList[position]
        Log.d("PokemonLog", "$pokemon")

        holder.binding.pokemonNameTV.text = pokemon.name.replaceFirstChar {
            if (it.isLowerCase()) it.titlecase(
                Locale.ROOT
            ) else it.toString()
        }
        holder.binding.pokemonIV.load(pokemon.pokemonImage)

        holder.binding.number.text = "#" + pokemon.id.toString()

    }

}