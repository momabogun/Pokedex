package com.example.pokedex.data.model

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.example.pokedex.data.model.pokemon.PokemonDb
import com.example.pokedex.data.model.pokemonAbilities.PokemonAbility
import com.example.pokedex.data.model.pokemonAbilities.PokemonAbilityCrossRef
import com.example.pokedex.data.model.pokemonMove.MoveDb
import com.example.pokedex.data.model.pokemonMove.PokemonMoveCrossRef
import com.example.pokedex.data.model.pokemonMove.VersionGroupDetails
import com.example.pokedex.data.model.pokemonStats.PokemonStatCrossRef
import com.example.pokedex.data.model.pokemonStats.Stat
import com.example.pokedex.data.model.pokemonType.PokemonType
import com.example.pokedex.data.model.pokemonType.PokemonTypeCrossRef

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
    val moves: List<MoveDb>,
    @Relation(
        parentColumn = "id",
        entityColumn = "level_learned_at",
        associateBy = Junction(
            value = PokemonMoveCrossRef::class,
            parentColumn = "pokemonId",
            entityColumn = "level"
        )
    )
    val levels: List<VersionGroupDetails>,
    @Relation(
        parentColumn = "id",
        entityColumn = "name",
        associateBy = Junction(
            value = PokemonTypeCrossRef::class,
            parentColumn = "pokemonId",
            entityColumn = "typeName"
        )
    )
    val types: List<PokemonType>,
    @Relation(
        parentColumn = "id",
        entityColumn = "name",
        associateBy = Junction(
            value = PokemonAbilityCrossRef::class,
            parentColumn = "pokemonId",
            entityColumn = "abilityName"
        )
    )
    val abilities: List<PokemonAbility>,

    @Relation(
        parentColumn = "id",
        entityColumn = "base_stat",
        associateBy = Junction(
            value = PokemonStatCrossRef::class,
            parentColumn = "pokemonId",
            entityColumn = "statValue"
        )
    )
    val stats: List<Stat>

)
