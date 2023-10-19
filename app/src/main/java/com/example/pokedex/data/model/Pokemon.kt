package com.example.pokedex.data.model

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation

data class Pokemon(
    @Embedded
    val pokemonDb: PokemonDb,
    @Relation(
        parentColumn = "id",
        entityColumn = "name",
        associateBy = Junction(
            value = PokemonMoveCrossRef::class,
            parentColumn = "pokemonId",
            entityColumn = "moveName"
        )
    )
    val moves: List<Move>

)
