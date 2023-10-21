package com.example.pokedex.data.model.pokemonAbilities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PokemonAbility(
    @PrimaryKey
    val name: String,
    val url: String
)