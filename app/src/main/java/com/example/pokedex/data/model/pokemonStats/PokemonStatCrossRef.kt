package com.example.pokedex.data.model.pokemonStats

import androidx.room.Entity
import androidx.room.ForeignKey
import com.example.pokedex.data.model.pokemon.PokemonDb
import com.example.pokedex.data.model.pokemonMove.MoveDb
import com.example.pokedex.data.model.pokemonMove.VersionGroupDetails

@Entity(
    primaryKeys = ["pokemonId", "statValue"],
    foreignKeys = [
        ForeignKey(
            entity = PokemonDb::class,
            parentColumns = ["id"],
            childColumns = ["pokemonId"]
        ),
        ForeignKey(
            entity = Stat::class,
            parentColumns = ["base_stat"],
            childColumns = ["statValue"]
        )]
)
data class PokemonStatCrossRef(
    val pokemonId: Int,
    val statValue: Int
)
