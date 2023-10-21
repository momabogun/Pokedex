package com.example.pokedex.data.model.pokemonMove

import androidx.room.Entity
import androidx.room.ForeignKey
import com.example.pokedex.data.model.pokemon.PokemonDb
import com.example.pokedex.data.model.pokemonMove.MoveDb
import com.example.pokedex.data.model.pokemonMove.VersionGroupDetails

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
