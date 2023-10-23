package com.example.pokedex.data.database

import com.example.pokedex.data.model.pokemon.PokemonDb

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.pokedex.data.model.pokemonAbilities.PokemonAbility
import com.example.pokedex.data.model.pokemonAbilities.PokemonAbilityCrossRef
import com.example.pokedex.data.model.pokemonEvolution.EvolutionDb
import com.example.pokedex.data.model.pokemonMove.PokemonMoveCrossRef
import com.example.pokedex.data.model.pokemonMove.MoveDb
import com.example.pokedex.data.model.pokemonType.PokemonType
import com.example.pokedex.data.model.pokemonType.PokemonTypeCrossRef
import com.example.pokedex.data.model.pokemonMove.VersionGroupDetails
import com.example.pokedex.data.model.pokemonStats.PokemonStatCrossRef
import com.example.pokedex.data.model.pokemonStats.StatDb
import com.example.pokedex.data.model.pokemonStats.StatName


@Database(
    entities = [
        PokemonDb::class,
        VersionGroupDetails::class,
        MoveDb::class,
        PokemonMoveCrossRef::class,
        PokemonAbility::class,
        PokemonAbilityCrossRef::class,
        PokemonType::class,
        PokemonTypeCrossRef::class,
        StatDb::class,
        PokemonStatCrossRef::class,
        StatName::class,
        EvolutionDb::class
    ], version = 1
)
abstract class PokeDatabase : RoomDatabase() {

    abstract val dao: PokemonDao
}

private lateinit var INSTANCE: PokeDatabase

fun getDatabase(context: Context): PokeDatabase {

    synchronized(PokeDatabase::class.java) {
        if (!::INSTANCE.isInitialized) {


            //Neue Datenbank Instanz erstellen
            INSTANCE = Room.databaseBuilder(
                context.applicationContext,
                PokeDatabase::class.java,
                "pokemon_database"
            ).fallbackToDestructiveMigration().build()
        }

        return INSTANCE
    }

}