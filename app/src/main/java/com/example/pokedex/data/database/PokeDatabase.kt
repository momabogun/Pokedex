package com.example.pokedex.data.database

import com.example.pokedex.data.model.PokemonDb

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.pokedex.data.model.PokemonMoveCrossRef
import com.example.pokedex.data.model.Move
import com.example.pokedex.data.model.MoveDb
import com.example.pokedex.data.model.VersionGroupDetails


@Database(entities = [
    PokemonDb::class,
    VersionGroupDetails::class,
    MoveDb::class,
    PokemonMoveCrossRef::class
                     ], version = 2)
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