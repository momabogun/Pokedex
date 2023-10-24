package com.example.pokedex.data.model.pokemon

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.pokedex.data.model.pokemonSpecies.Generation

@Entity(tableName = "pokemon")
class PokemonDb(
    @PrimaryKey
    val id: Int,
    val name:String,
    val pokemonImage: String,
    val weight: Int,
    val height: Int,
    val aboutText: String,
    val habitat: String,
    val generation: String,
    val evolution: Int,

)