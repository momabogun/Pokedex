package com.example.pokedex.data.database

import com.example.pokedex.data.model.Pokemon

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Pokemon::class], version = 1)
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
            )
                .build()
        }

        return INSTANCE
    }

}