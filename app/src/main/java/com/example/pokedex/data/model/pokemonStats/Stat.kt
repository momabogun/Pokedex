package com.example.pokedex.data.model.pokemonStats

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Stat(
    @PrimaryKey
    val base_stat: Int
)
