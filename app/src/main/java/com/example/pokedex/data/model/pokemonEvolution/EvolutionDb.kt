package com.example.pokedex.data.model.pokemonEvolution

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "evolution")
class EvolutionDb (
    @PrimaryKey
    val evoId: Int,
    val basicName: String,
    val basicPicture: String?,
    val firstEvoName: String?,
    val firstEvoPicture: String,
    val secondEvoName: String?,
    val secondEvoPicture: String?,
    val levelToEvolve: Int?,
    val levelToEvolveSecond: Int?
)