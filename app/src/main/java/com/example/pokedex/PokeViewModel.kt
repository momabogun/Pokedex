package com.example.pokedex

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.pokedex.data.AppRepository
import com.example.pokedex.data.database.getDatabase
import com.example.pokedex.data.model.Pokemon
import com.example.pokedex.data.model.PokemonApi
import com.example.pokedex.data.remote.PokeApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PokeViewModel(app: Application) : AndroidViewModel(app){


    val repository = AppRepository(PokeApi.retrofitService, getDatabase(app))


    val pokemon : LiveData<List<Pokemon>> = repository.pokemon


init {
    loadPokeList()
}



    fun loadPokeList(){

        viewModelScope.launch(Dispatchers.IO) {
            repository.getPokemonList()

        }
    }
}