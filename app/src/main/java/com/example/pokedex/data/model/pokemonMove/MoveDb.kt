package com.example.pokedex.data.model.pokemonMove

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "moves")
data class MoveDb (
    val id: Int,
    @PrimaryKey
    val name : String,
    val type : String,
    val power: Int?,
    val accuracy: Int?,
    val pp : Int?,
    val category: String,
)