package com.example.pokedex.data

import com.example.pokedex.data.database.PokeDatabase
import com.example.pokedex.data.model.Pokemon
import com.example.pokedex.data.model.PokemonInResponse
import com.example.pokedex.data.remote.ApiService

class AppRepository(val apiService: ApiService, val db: PokeDatabase) {

    val pokemon = db.dao.getAllPokemon()

    suspend fun getPokemonList() {
        val pokeList = apiService.getPokemonList().results

        for (pokemonInResponse in pokeList) {
            if (!db.dao.pokemonExists(pokemonInResponse.id)) {
                loadPokemon(pokemonInResponse)
            }

        }
    }


    suspend fun loadPokemon(pokemonInResponse: PokemonInResponse) {
        val pokemonWithDetail = apiService.getPokemonByName(pokemonInResponse.name)
        val pokemonDb = Pokemon(
            id = pokemonWithDetail.id,
            name = pokemonWithDetail.name,
            pokemonImage = pokemonWithDetail.sprites.other.officialArtwork.front_default
        )
        db.dao.insertPokemon(pokemonDb)
    }
}