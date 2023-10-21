package com.example.pokedex.data.model.pokemon

class PokemonInResponse (
    val name: String,
    val url: String,
) {
    //url = https://pokeapi.co/api/v2/pokemon/1/
    //split = ["https:","","pokeapi.co","api","v2","pokemon","1",""]
    private val split = url.split('/')
    val id = split[split.size - 2].toInt()
}