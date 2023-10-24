package com.example.pokedex.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.pokedex.PokedexFragment
import com.example.pokedex.PokedexFragmentDirections
import com.example.pokedex.data.GenMenu
import com.example.pokedex.data.model.Pokemon
import com.example.pokedex.databinding.ListItemBinding
import com.example.pokedex.databinding.ListPokedexBinding

class GenAdapter (val generationList: List<GenMenu>
) : RecyclerView.Adapter<GenAdapter.GenerationViewHolder>() {

    inner class GenerationViewHolder(val binding: ListPokedexBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenerationViewHolder {
        val binding = ListPokedexBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GenerationViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return generationList.size
    }


    override fun onBindViewHolder(holder: GenerationViewHolder, position: Int) {

        val gen = generationList[position]

        holder.binding.pokemonIV.load(gen.picture)

        holder.binding.pokemonNameTV.text = gen.name


        holder.itemView.setOnClickListener {
            val navController = holder.itemView.findNavController()
            navController.navigate(PokedexFragmentDirections.actionPokedexFragmentToHomeFragment(gen.id))
        }

    }
}