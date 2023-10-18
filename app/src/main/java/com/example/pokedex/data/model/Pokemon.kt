package com.example.pokedex.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pokemon")
class Pokemon(
    @PrimaryKey
    val id: Int,
    val name:String,
    val pokemonImage: String

)