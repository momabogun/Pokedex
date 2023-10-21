package com.example.pokedex.data.model.pokemonEvolution

data class EvolutionInResponse(
    val url: String
){
    private val split = url.split('/')
    val id = split[split.size - 2].toInt()
}
