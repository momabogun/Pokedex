package com.example.pokedex.data.model.pokemonType

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity
data class PokemonType (
    @PrimaryKey
    val name: String,
    val url:String
)