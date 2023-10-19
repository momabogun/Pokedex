package com.example.pokedex.data.model

import androidx.room.Entity
import androidx.room.ForeignKey

@Entity(
    primaryKeys = ["pokemonId", "moveName"],
    foreignKeys = [
        ForeignKey(
            entity = PokemonDb::class,
            parentColumns = ["id"],
            childColumns = ["pokemonId"]
        ),
    ForeignKey(
        entity = Move::class,
        parentColumns = ["name"],
        childColumns = ["moveName"]
    )
    ]
)
data class PokemonMoveCrossRef(
    val pokemonId: Int,
    val moveName: String
)
