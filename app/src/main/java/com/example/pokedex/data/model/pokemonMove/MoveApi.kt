package com.example.pokedex.data.model.pokemonMove

import com.squareup.moshi.Json

data class MoveApi(
    val id: Int,
    val power: Int?,
    val name: String,
    val accuracy: Int?,
    val pp: Int?,
    @Json(name = "damage_class")
    val category: MoveCategory,
    val type: MoveType

)

data class MoveCategory(
    val name: String
)

data class MoveType(
    val name: String
)
