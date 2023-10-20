package com.example.pokedex.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedex.R
import com.example.pokedex.data.model.Move
import com.example.pokedex.data.model.MoveDb
import com.example.pokedex.data.model.PokemonDb
import com.example.pokedex.data.model.VersionGroupDetails
import com.example.pokedex.databinding.ListItemBinding
import com.example.pokedex.databinding.ListMovesBinding
import java.util.Locale

class MovesAdapter(
    val movesList: MutableList<MoveDb>,
    val detailsList: MutableList<VersionGroupDetails>
) : RecyclerView.Adapter<MovesAdapter.MoveViewHolder>() {

    inner class MoveViewHolder(val binding: ListMovesBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoveViewHolder {
        val binding = ListMovesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MoveViewHolder(binding)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MoveViewHolder, position: Int) {


        val combinedList = movesList.zip(detailsList)
        val (nonZeroLevelItems, zeroLevelItems) = combinedList.partition { it.second.level_learned_at >= 1 }
        val sortedNonZeroLevelItems = nonZeroLevelItems.sortedBy { it.second.level_learned_at }
        val sortedList = sortedNonZeroLevelItems + zeroLevelItems
        movesList.clear()
        detailsList.clear()
        for ((move, details) in sortedList) {
            movesList.add(move)
            detailsList.add(details)
        }

        val move = movesList[position]

        when(move.type) {
            "fire" -> holder.binding.typeMoveIV.setImageResource(R.drawable.fire_type_symbol_galar_by_jormxdos_dffvl1m)
            "grass"-> holder.binding.typeMoveIV.setImageResource(R.drawable.grass_type_symbol_galar_by_jormxdos_dffvl0s)
            "normal"-> holder.binding.typeMoveIV.setImageResource(R.drawable.normal_type_symbol_galar_by_jormxdos_dffvl62)
            "poison"->holder.binding.typeMoveIV.setImageResource(R.drawable.poison_type_symbol_galar_by_jormxdos_dffvl5p)
            "water"->holder.binding.typeMoveIV.setImageResource(R.drawable.water_type_symbol_galar_by_jormxdos_dffvl12)
            "rock"->holder.binding.typeMoveIV.setImageResource(R.drawable.rock_type_symbol_galar_by_jormxdos_dffvl3a)
            "fairy"->holder.binding.typeMoveIV.setImageResource(R.drawable.fairy_type_symbol_galar_by_jormxdos_dffvl2x)
            "bug"->holder.binding.typeMoveIV.setImageResource(R.drawable.bug_type_symbol_galar_by_jormxdos_dffvl73)
            "dark"->holder.binding.typeMoveIV.setImageResource(R.drawable.dark_type_symbol_galar_by_jormxdos_dffvl4c)
            "dragon"->holder.binding.typeMoveIV.setImageResource(R.drawable.dragon_type_symbol_galar_by_jormxdos_dffvl4n)
            "fighting"->holder.binding.typeMoveIV.setImageResource(R.drawable.fighting_type_symbol_galar_by_jormxdos_dffvl1w)
            "ghost"->holder.binding.typeMoveIV.setImageResource(R.drawable.ghost_type_symbol_galar_by_jormxdos_dffvl2d)
            "flying"->holder.binding.typeMoveIV.setImageResource(R.drawable.flying_type_symbol_galar_by_jormxdos_dffvl6n)
            "ground"->holder.binding.typeMoveIV.setImageResource(R.drawable.ground_type_symbol_galar_by_jormxdos_dffvl6w)
            "ice"->holder.binding.typeMoveIV.setImageResource(R.drawable.ice_type_symbol_galar_by_jormxdos_dffvl40)
            "psychic"->holder.binding.typeMoveIV.setImageResource(R.drawable.psychic_type_symbol_galar_by_jormxdos_dffvl5b)
            "steel"->holder.binding.typeMoveIV.setImageResource(R.drawable.steel_type_symbol_galar_by_jormxdos_dffvl50)

        }

        when(move.category){
            "special"->holder.binding.categoryMoveIV.setImageResource(R.drawable.special_move_icon_by_jormxdos_dfgb60n)
            "physical"->holder.binding.categoryMoveIV.setImageResource(R.drawable.physical_move_icon_by_jormxdos_dfgb60u)
            "status"->holder.binding.categoryMoveIV.setImageResource(R.drawable.status_move_icon_by_jormxdos_dfgb616)

        }



        holder.binding.moveNameTV.text = move.name.replaceFirstChar {
            if (it.isLowerCase()) it.titlecase(
                Locale.ROOT
            ) else it.toString()
        }
        val details = detailsList[position]
        holder.binding.levelTV.text = if (details.level_learned_at > 0){
            "Lv" + details.level_learned_at.toString()
        } else{
            "Egg moves"
        }


    }

    override fun getItemCount(): Int {
        return movesList.size
    }


}
