package com.example.pokedex.data.model.pokemonStats

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class StatDb (
    @PrimaryKey
    val value: Int
)