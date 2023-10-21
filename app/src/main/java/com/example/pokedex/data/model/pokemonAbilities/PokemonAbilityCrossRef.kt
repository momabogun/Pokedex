package com.example.pokedex.data.model.pokemonAbilities

import androidx.room.Entity
import androidx.room.ForeignKey
import com.example.pokedex.data.model.pokemon.PokemonDb
@Entity(
    primaryKeys = ["pokemonId", "abilityName"],
    foreignKeys = [
        ForeignKey(
            entity = PokemonDb::class,
            parentColumns = ["id"],
            childColumns = ["pokemonId"]
        ),
        ForeignKey(
            entity = PokemonAbility::class,
            parentColumns = ["name"],
            childColumns = ["abilityName"]
        )
    ]
)
data class PokemonAbilityCrossRef(
    val pokemonId: Int,
    val abilityName: String
)



