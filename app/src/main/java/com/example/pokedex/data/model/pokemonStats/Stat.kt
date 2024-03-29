package com.example.pokedex.data.model.pokemonStats

import androidx.room.Entity
import androidx.room.PrimaryKey


data class Stat(
    val stat: StatName,
    val base_stat: Int
)
@Entity("stat")
data class StatName (
    @PrimaryKey
    val name: String
)