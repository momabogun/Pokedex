package com.example.pokedex.data.model


data class SpeciesApi(
    val color: Color,
    val flavor_text_entries: List<TextEntry>,
    val habitat: Habitat,
    val generation: Generation

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
