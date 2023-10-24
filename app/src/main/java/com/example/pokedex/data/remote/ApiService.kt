package com.example.pokedex.data.remote

import com.example.pokedex.data.model.pokemonMove.MoveApi
import com.example.pokedex.data.model.pokemon.PokemonApi
import com.example.pokedex.data.model.pokemon.PokemonImageResponse
import com.example.pokedex.data.model.pokemon.ResponseList
import com.example.pokedex.data.model.pokemonEvolution.EvolutionApi
import com.example.pokedex.data.model.pokemonSpecies.SpeciesApi
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

const val BASE_URL = "https://pokeapi.co/api/v2/"


private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface ApiService {

    @GET("pokemon?limit=30")
    suspend fun getPokemonList() : ResponseList






    @GET("pokemon/{pokemonId}")
    suspend fun getPokemonById(@Path("pokemonId") pokemonId: Int) : PokemonApi

    @GET("pokemon/{pokemonName}")
    suspend fun getPokemonByName(@Path("pokemonName") pokemonName: String) : PokemonApi

    @GET("evolution-chain/{evolutionId}")
    suspend fun getEvolutionByID(@Path("evolutionId")evolutionId: Int): EvolutionApi

    @GET("pokemon/{name}/")
    suspend fun getPokemonImageByName(@Path("name") name: String): PokemonImageResponse



    @GET("move/{moveId}")
    suspend fun getMoveById(@Path("moveId") moveId: Int): MoveApi


    @GET("pokemon-species/{pokemonName}")
    suspend fun getPokemonSpecies(@Path("pokemonName") pokemonName: String): SpeciesApi


}

object PokeApi {
    val retrofitService: ApiService by lazy { retrofit.create(ApiService::class.java) }
}