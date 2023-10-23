package com.example.pokedex.data.model.pokemon

import com.example.pokedex.data.model.pokemonAbilities.PokemonAbility
import com.example.pokedex.data.model.pokemonType.PokemonType
import com.example.pokedex.data.model.pokemonMove.Move
import com.example.pokedex.data.model.pokemonMove.VersionGroupDetails
import com.example.pokedex.data.model.pokemonSpecies.SpeciesInResponse
import com.example.pokedex.data.model.pokemonStats.Stat
import com.squareup.moshi.Json

data class PokemonApi(
    val id: Int,
    val name: String,
    val sprites: Sprites,
    val height: Int,
    val weight: Int,
    val moves: List<MovesWithDetails>,
    val types: List<Types>,
    val species: SpeciesInResponse,
    val abilities: List<Abilities>,
    val stats: List<Stat>
)


data class Abilities(
    val ability: PokemonAbility
)


data class Sprites(
    val other: Other
)

data class Types(
    val type: PokemonType
)


data class Other(
    @Json(name = "official-artwork")
    val officialArtwork: OfficialArtwork
)

data class OfficialArtwork(
    val front_default: String
)

data class MovesWithDetails(
    val move: Move,
    val version_group_details: List<VersionGroupDetails>
)


