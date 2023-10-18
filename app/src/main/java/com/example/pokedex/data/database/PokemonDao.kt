package com.example.pokedex.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.IGNORE
import androidx.room.Query
import com.example.pokedex.data.model.Pokemon

@Dao
interface PokemonDao {

    @Query("SELECT * FROM pokemon")
    fun getAllPokemon(): LiveData<List<Pokemon>>


    @Insert(onConflict = IGNORE)
    fun insertPokemon(pokemon: Pokemon)


    @Query("SELECT EXISTS(SELECT * FROM pokemon WHERE id=:id) ")
    fun pokemonExists(id: Int): Boolean

}