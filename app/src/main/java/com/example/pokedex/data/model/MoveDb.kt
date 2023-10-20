package com.example.pokedex.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "move")
data class MoveDb (
    val id: Int,
    @PrimaryKey
    val name : String,
    val type : String,
    val power: Int?,
    val pp : Int?,
    val category: String,
)