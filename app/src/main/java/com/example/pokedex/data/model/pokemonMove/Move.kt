package com.example.pokedex.data.model.pokemonMove

import androidx.room.Entity
import androidx.room.PrimaryKey
data class Move(
    val name: String,
    val url: String,
){
    //url = https://pokeapi.co/api/v2/move/580/
    //split = ["https:","","pokeapi.co","api","v2","move","580",""]
    private val split = url.split('/')
    val id = split[split.size - 2].toInt()
}



@Entity
data class VersionGroupDetails(
    @PrimaryKey
    val level_learned_at: Int
)
