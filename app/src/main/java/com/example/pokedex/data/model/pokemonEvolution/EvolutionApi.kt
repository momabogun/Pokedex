package com.example.pokedex.data.model.pokemonEvolution

data class EvolutionApi(
    val id: Int,
    val chain: EvolutionChain
)






data class EvolutionChain(
    val evolution_details: List<EvolutionDetails>,
    val evolves_to: List<EvolutionChain>,
    val species: BasicForm
)





data class BasicForm(
    val name: String
)

data class EvolutionDetails(
    val min_level: Int
)



