package com.example.pokedex.data.model.pokemonType

import androidx.room.Entity
import androidx.room.ForeignKey
import com.example.pokedex.data.model.pokemon.PokemonDb
import com.example.pokedex.data.model.pokemonType.PokemonType


@Entity(
    primaryKeys = ["pokemonId", "typeName"],
    foreignKeys = [
        ForeignKey(
            entity = PokemonDb::class,
            parentColumns = ["id"],
            childColumns = ["pokemonId"]
        ),
        ForeignKey(
            entity = PokemonType::class,
            parentColumns = ["name"],
            childColumns = ["typeName"]
        )
    ]
)
data class PokemonTypeCrossRef(
    val pokemonId: Int,
    val typeName: String
)