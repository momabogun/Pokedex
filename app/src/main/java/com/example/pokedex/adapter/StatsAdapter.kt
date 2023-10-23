package com.example.pokedex.adapter

import android.annotation.SuppressLint
import android.content.res.ColorStateList
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedex.data.model.pokemonStats.Stat
import com.example.pokedex.data.model.pokemonStats.StatDb
import com.example.pokedex.data.model.pokemonStats.StatName
import com.example.pokedex.databinding.ListStatsBinding
import java.util.Locale

class StatsAdapter(
    val statList: List<StatDb>,
    val statName: List<StatName>
) : RecyclerView.Adapter<StatsAdapter.StatViewHolder>() {

    inner class StatViewHolder(val binding: ListStatsBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StatViewHolder {
        val binding = ListStatsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return StatViewHolder(binding)
    }

    @SuppressLint("ResourceAsColor")
    override fun onBindViewHolder(holder: StatViewHolder, position: Int) {
        val stat = statList[position]
        val statName = statName[position]
holder.binding.statNameTV.text = statName.name.split("special-defense").joinToString("Sp. Def").split("special-attack").joinToString("Sp. Atk").replaceFirstChar {
    if (it.isLowerCase()) it.titlecase(
        Locale.ROOT
    ) else it.toString()
}
        holder.binding.statValueTV.text = stat.value.toString()

        val progressBar = holder.binding.barChart
        progressBar.max = 100
        val progress = stat.value

        if (progress < 50) {

            progressBar.progressTintList = ColorStateList.valueOf(Color.parseColor("#E53935"))

        }  else if (progress in 51..79){
            progressBar.progressTintList = ColorStateList.valueOf(Color.parseColor("#FDD835"))
        }
        else{
            progressBar.progressTintList = ColorStateList.valueOf(Color.parseColor("#7CB342"))
        }

        progressBar.progress = progress

    }

    override fun getItemCount(): Int {
        return statList.size
    }
}