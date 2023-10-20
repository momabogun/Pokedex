package com.example.pokedex.data.model

import com.squareup.moshi.Json

data class PokemonApi(
    val id: Int,
    val name: String,
    val sprites:Sprites,
    val height: Int,
    val weight: Int,
    val moves: List<MovesWithDetails>
)


data class Sprites(
    val other: Other
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


