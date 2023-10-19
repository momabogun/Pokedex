package com.example.pokedex.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedex.data.model.Move
import com.example.pokedex.data.model.PokemonDb
import com.example.pokedex.databinding.ListItemBinding
import com.example.pokedex.databinding.ListMovesBinding
import java.util.Locale

class MovesAdapter(
    val movesList: List<Move>
) : RecyclerView.Adapter<MovesAdapter.MoveViewHolder>() {

    inner class MoveViewHolder(val binding: ListMovesBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoveViewHolder {
        val binding = ListMovesBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return MoveViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return movesList.size
    }
    override fun onBindViewHolder(holder: MoveViewHolder, position: Int) {

        val move = movesList[position]
        holder.binding.moveNameTV.text = move.name.replaceFirstChar {
            if (it.isLowerCase()) it.titlecase(
                Locale.ROOT
            ) else it.toString()
        }
    }


    }
