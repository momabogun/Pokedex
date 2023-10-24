package com.example.pokedex.data.model.pokemonEvolution

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "evolution")
class EvolutionDb (
    @PrimaryKey
    val evoId: Int,
    val basicName: String,
    val firstEvoName: String?,
    val secondEvoName: String?,
    val levelToEvolve: Int?,
    val levelToEvolveSecond: Int?,
    val evoBasic: String,
    val evoFirst: String?,
    val evoSecond: String?
)