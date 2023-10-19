package com.example.pokedex.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pokemon")
class PokemonDb(
    @PrimaryKey
    val id: Int,
    val name:String,
    val pokemonImage: String,
    val weight: Int,
    val height: Int

)