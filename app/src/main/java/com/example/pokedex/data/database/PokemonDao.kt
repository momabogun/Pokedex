package com.example.pokedex.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.IGNORE
import androidx.room.Query
import com.example.pokedex.data.model.MoveDb
import com.example.pokedex.data.model.Pokemon
import com.example.pokedex.data.model.PokemonDb
import com.example.pokedex.data.model.PokemonMoveCrossRef
import com.example.pokedex.data.model.VersionGroupDetails

@Dao
interface PokemonDao {

    @Query("SELECT * FROM pokemon")
    fun getAllPokemon(): LiveData<List<Pokemon>>


    @Insert(onConflict = IGNORE)
    fun insertPokemon(pokemonDb: PokemonDb)

    @Insert(onConflict = IGNORE)
    fun insertMove(move: MoveDb)

    @Insert(onConflict = IGNORE)
    fun insertLevel(level: VersionGroupDetails)



    @Insert(onConflict = IGNORE)
    fun insertPokemonMoveCrossRef(crossRef: PokemonMoveCrossRef)


    @Query("SELECT EXISTS(SELECT * FROM pokemon WHERE id=:id) ")
    fun pokemonExists(id: Int): Boolean



    @Query("SELECT * FROM pokemon WHERE id = :id")
    fun getPokemon(id: Int): LiveData<Pokemon>

}