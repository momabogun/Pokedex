package com.example.pokedex.data.model.pokemonSpecies

data class SpeciesInResponse(
    val name: String,
    val url:String
) {
    private val split = url.split('/')
    val id = split[split.size - 2].toInt()
}
