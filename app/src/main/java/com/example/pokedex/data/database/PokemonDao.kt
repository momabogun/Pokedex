package com.example.pokedex.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.IGNORE
import androidx.room.Query
import com.example.pokedex.data.model.pokemonMove.MoveDb
import com.example.pokedex.data.model.Pokemon
import com.example.pokedex.data.model.pokemon.PokemonDb
import com.example.pokedex.data.model.pokemonAbilities.PokemonAbility
import com.example.pokedex.data.model.pokemonAbilities.PokemonAbilityCrossRef
import com.example.pokedex.data.model.pokemonEvolution.EvolutionDb
import com.example.pokedex.data.model.pokemonMove.PokemonMoveCrossRef
import com.example.pokedex.data.model.pokemonType.PokemonType
import com.example.pokedex.data.model.pokemonType.PokemonTypeCrossRef
import com.example.pokedex.data.model.pokemonMove.VersionGroupDetails
import com.example.pokedex.data.model.pokemonStats.PokemonStatCrossRef
import com.example.pokedex.data.model.pokemonStats.StatDb
import com.example.pokedex.data.model.pokemonStats.StatName


@Dao
interface PokemonDao {

    @Query("SELECT * FROM pokemon")
    fun getAllPokemon(): LiveData<List<Pokemon>>


    @Insert(onConflict = IGNORE)
    fun insertPokemon(pokemonDb: PokemonDb)

    @Insert(onConflict = IGNORE)
    fun insertType(pokemonType: PokemonType)

    @Insert(onConflict = IGNORE)
    fun insertAbility(pokemonAbility: PokemonAbility)

    @Insert(onConflict = IGNORE)
    fun insertMove(move: MoveDb)



    @Insert(onConflict = IGNORE)
    fun insertEvolution(evolutionDb: EvolutionDb)

    @Insert(onConflict = IGNORE)
    fun insertLevel(level: VersionGroupDetails)

    @Insert(onConflict = IGNORE)
    fun insertStat(stat: StatDb)

    @Insert(onConflict = IGNORE)
    fun insertStatName(name: StatName)

    @Insert(onConflict = IGNORE)
    fun insertPokemonStatCrossRef(crossRef: PokemonStatCrossRef)

    @Insert(onConflict = IGNORE)
    fun insertPokemonMoveCrossRef(crossRef: PokemonMoveCrossRef)


    @Insert(onConflict = IGNORE)
    fun insertPokemonTypeCrossRef(crossRef: PokemonTypeCrossRef)





    @Insert(onConflict = IGNORE)
    fun insertPokemonAbilityCrossRef(crossRef: PokemonAbilityCrossRef)


    @Query("SELECT EXISTS(SELECT * FROM pokemon WHERE id=:id) ")
    fun pokemonExists(id: Int): Boolean



    @Query("SELECT * FROM pokemon WHERE id = :id")
    fun getPokemon(id: Int): LiveData<Pokemon>

    @Query("SELECT * FROM pokemon WHERE name = :name")
    fun getPokemonByName(name: String): Pokemon


    @Query("SELECT * FROM evolution WHERE evoId = :id")
    fun getEvolution(id: Int): LiveData<EvolutionDb>

}