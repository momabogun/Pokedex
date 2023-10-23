package com.example.pokedex.data

import androidx.lifecycle.LiveData
import com.example.pokedex.data.database.PokeDatabase
import com.example.pokedex.data.model.pokemonMove.MoveDb
import com.example.pokedex.data.model.Pokemon
import com.example.pokedex.data.model.pokemon.PokemonDb
import com.example.pokedex.data.model.pokemon.PokemonInResponse
import com.example.pokedex.data.model.pokemonAbilities.PokemonAbilityCrossRef
import com.example.pokedex.data.model.pokemonEvolution.EvolutionDb
import com.example.pokedex.data.model.pokemonMove.PokemonMoveCrossRef
import com.example.pokedex.data.model.pokemonStats.PokemonStatCrossRef
import com.example.pokedex.data.model.pokemonStats.StatDb

import com.example.pokedex.data.model.pokemonType.PokemonTypeCrossRef
import com.example.pokedex.data.remote.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.Exception

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


    fun getEvolution(evoId: Int):LiveData<EvolutionDb> = db.dao.getEvolution(evoId)

    fun getPokemon(pokeId: Int): LiveData<Pokemon> = db.dao.getPokemon(pokeId)


    suspend fun loadPokemon(pokemonInResponse: PokemonInResponse) {
        withContext(Dispatchers.IO) {
            val pokemonWithDetail = apiService.getPokemonByName(pokemonInResponse.name)
            val speciesWithDetails = apiService.getPokemonSpecies(pokemonWithDetail.name)
            val evolution = apiService.getEvolutionByID(pokemonWithDetail.id)
            val pokemonDb = PokemonDb(
                id = pokemonWithDetail.id,
                name = pokemonWithDetail.name,
                pokemonImage = pokemonWithDetail.sprites.other.officialArtwork.front_default,
                weight = pokemonWithDetail.weight,
                height = pokemonWithDetail.height,
                aboutText = speciesWithDetails.flavor_text_entries[1].flavor_text,
                generation = speciesWithDetails.generation.name,
                habitat = speciesWithDetails.habitat.name,
                evolution = speciesWithDetails.evolution_chain.id
            )
            db.dao.insertPokemon(pokemonDb)

                val evolutionDb = EvolutionDb(
                    evoId = evolution.id,
                    basicName = evolution.chain.species.name,
                    firstEvoName = evolution.chain.evolves_to.getOrNull(0)?.species?.name ?: "",
                    levelToEvolve = evolution.chain.evolves_to.getOrNull(0)?.evolution_details
                        ?.firstOrNull { it.min_level != null }
                        ?.min_level ?: 0,
                    secondEvoName = evolution.chain.evolves_to.getOrNull(0)?.evolves_to?.getOrNull(0)?.species?.name ?: "",
                    levelToEvolveSecond = evolution.chain.evolves_to.getOrNull(0)?.evolves_to?.getOrNull(0)?.evolution_details?.getOrNull(0)?.min_level ?: 0,
                    basicPicture = db.dao.getPokemonByName(evolution.chain.species.name)?.pokemonDb?.pokemonImage ?: "",
                    firstEvoPicture = db.dao.getPokemonByName(evolution.chain.evolves_to.getOrNull(0)?.species?.name ?: "").pokemonDb.pokemonImage,
                    secondEvoPicture = db.dao.getPokemonByName(evolution.chain.evolves_to.getOrNull(0)?.evolves_to?.getOrNull(0)?.species?.name ?: "")?.pokemonDb?.pokemonImage ?: ""
                )

            db.dao.insertEvolution(evolutionDb)








            for (type in pokemonWithDetail.types) {
                db.dao.insertType(type.type)
                val crossRef = PokemonTypeCrossRef(pokemonWithDetail.id, type.type.name)
                db.dao.insertPokemonTypeCrossRef(crossRef)
            }


            for (ability in pokemonWithDetail.abilities) {
                db.dao.insertAbility(ability.ability)
                val crossRef = PokemonAbilityCrossRef(pokemonWithDetail.id, ability.ability.name)
                db.dao.insertPokemonAbilityCrossRef(crossRef)
            }


            for (stat in pokemonWithDetail.stats) {
                db.dao.insertStatName(stat.stat)
                val statDb = StatDb(
                    value = stat.base_stat
                )
                db.dao.insertStat(statDb)
                val crossRef = PokemonStatCrossRef(pokemonWithDetail.id,stat.stat.name, statDb.value)
                db.dao.insertPokemonStatCrossRef(crossRef)
            }


            for (moveInResponse in pokemonWithDetail.moves) {
                val moveWithDetails = apiService.getMoveById(moveInResponse.move.id)
                val level = moveInResponse.version_group_details[0]
                val moveDb = MoveDb(
                    id = moveWithDetails.id,
                    name = moveWithDetails.name,
                    type = moveWithDetails.type.name,
                    power = moveWithDetails.power,
                    pp = moveWithDetails.pp,
                    category = moveWithDetails.category.name,
                    accuracy = moveWithDetails.accuracy
                )
                db.dao.insertMove(moveDb)
                db.dao.insertLevel(level)
                val crossRef = PokemonMoveCrossRef(
                    pokemonWithDetail.id,
                    moveWithDetails.name,
                    level.level_learned_at
                )
                db.dao.insertPokemonMoveCrossRef(crossRef)
            }
        }
    }
}