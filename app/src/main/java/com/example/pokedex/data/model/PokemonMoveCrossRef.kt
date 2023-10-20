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
            entity = MoveDb::class,
            parentColumns = ["name"],
            childColumns = ["moveName"]
        ),
        ForeignKey(
            entity = VersionGroupDetails::class,
            parentColumns = ["level_learned_at"],
            childColumns = ["level"]
        )]
)
data class PokemonMoveCrossRef(
    val pokemonId: Int,
    val moveName: String,
    val level: Int
)
