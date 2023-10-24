package com.example.pokedex

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.pokedex.data.AppRepository
import com.example.pokedex.data.database.getDatabase
import com.example.pokedex.data.model.Pokemon
import com.example.pokedex.data.model.pokemon.ResponseList
import com.example.pokedex.data.model.pokemonEvolution.EvolutionDb
import com.example.pokedex.data.remote.PokeApi
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException

class PokeViewModel(app: Application) : AndroidViewModel(app) {


    val repository = AppRepository(PokeApi.retrofitService, getDatabase(app))


    val pokemon: LiveData<List<Pokemon>> = repository.pokemon


    val pokemon2: LiveData<List<Pokemon>> = repository.pokemon2

    val pokemon3: LiveData<List<Pokemon>> = repository.pokemon3









    init {
        loadPokeList()
    }


    fun getPokemon(pokeId: Int): LiveData<Pokemon> = repository.getPokemon(pokeId)

    fun getEvolution(evoId: Int): LiveData<EvolutionDb> = repository.getEvolution(evoId)






    fun loadPokeList() {

            viewModelScope.launch(Dispatchers.IO) {
                repository.getPokemonList()

            }
        }
    }