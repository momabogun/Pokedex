package com.example.pokedex.data.model.pokemonSpecies

import com.example.pokedex.data.model.pokemonEvolution.EvolutionInResponse


data class SpeciesApi(
    val id: Int,
    val color: Color,
    val flavor_text_entries: List<TextEntry>,
    val habitat: Habitat,
    val generation: Generation,
    val evolution_chain: EvolutionInResponse,
    val evolves_from_species: IfBasicNullable?

)


data class IfBasicNullable(
    val name: String,
    val url: String
)



data class Color(
    val name: String
)


data class TextEntry(
    val flavor_text: String
)

data class Habitat(
    val name: String
)

data class Generation(
    val name: String
)
