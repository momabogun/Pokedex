package com.example.pokedex.data.remote

import com.example.pokedex.data.model.PokemonApi
import com.example.pokedex.data.model.ResponseList
import com.example.pokedex.data.model.SpeciesApi
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
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

    @GET("pokemon?limit=100")
    suspend fun getPokemonList() : ResponseList

    @GET("pokemon/{pokemonName}")
    suspend fun getPokemonByName(@Path("pokemonName") pokemonName: String) : PokemonApi


    @GET("pokemon-species/{pokemonName}")
    suspend fun getPokemonSpecies(@Path("pokemonName") pokemonName: String): SpeciesApi


}

object PokeApi {
    val retrofitService: ApiService by lazy { retrofit.create(ApiService::class.java) }
}