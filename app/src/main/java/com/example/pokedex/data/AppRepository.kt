package com.example.pokedex.data

import androidx.lifecycle.LiveData
import com.example.pokedex.data.database.PokeDatabase
import com.example.pokedex.data.model.Pokemon
import com.example.pokedex.data.model.PokemonDb
import com.example.pokedex.data.model.PokemonInResponse
import com.example.pokedex.data.model.PokemonMoveCrossRef
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

    fun getPokemon(pokeId: Int):LiveData<Pokemon> = db.dao.getPokemon(pokeId)


    suspend fun loadPokemon(pokemonInResponse: PokemonInResponse) {
        val pokemonWithDetail = apiService.getPokemonByName(pokemonInResponse.name)
        val pokemonDb = PokemonDb(
            id = pokemonWithDetail.id,
            name = pokemonWithDetail.name,
            pokemonImage = pokemonWithDetail.sprites.other.officialArtwork.front_default,
            weight = pokemonWithDetail.weight,
            height = pokemonWithDetail.height
        )
        db.dao.insertPokemon(pokemonDb)

        for (moveInResponse in pokemonWithDetail.moves){
            val move = moveInResponse.move
            db.dao.insertMove(move)
            val crossRef = PokemonMoveCrossRef(pokemonWithDetail.id,move.name)
            db.dao.insertPokemonMoveCrossRef(crossRef)
        }
    }
}