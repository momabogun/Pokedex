package com.example.pokedex.data.model.pokemonStats

import androidx.room.Entity
import androidx.room.ForeignKey
import com.example.pokedex.data.model.pokemon.PokemonDb
import com.example.pokedex.data.model.pokemonMove.MoveDb
import com.example.pokedex.data.model.pokemonMove.VersionGroupDetails

@Entity(
    primaryKeys = ["pokemonId", "statName"],
    foreignKeys = [
        ForeignKey(
            entity = PokemonDb::class,
            parentColumns = ["id"],
            childColumns = ["pokemonId"]
        ),
        ForeignKey(
            entity = StatName::class,
            parentColumns = ["name"],
            childColumns = ["statName"]
        ),
        ForeignKey(
            entity = StatDb::class,
            parentColumns = ["value"],
            childColumns = ["valueCross"]
        )]
)
data class PokemonStatCrossRef(
    val pokemonId: Int,
    val statName: String,
    val valueCross: Int
)