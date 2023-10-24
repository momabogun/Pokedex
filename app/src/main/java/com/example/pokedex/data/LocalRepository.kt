package com.example.pokedex.data

import com.example.pokedex.R

class LocalRepository {





    fun generationList(): List<GenMenu> {
        return listOf(
            GenMenu(1,
                "Generation I",
                R.drawable.pokemon___kanto_starters_by_quas_quas_da3i8qu_375w_2x
            ),
            GenMenu(2,
                "Generation II",
                R.drawable.pokemon___johto_starters_by_quas_quas_da3pu5u_375w_2x
            ),
            GenMenu(3,
                "Generation III",
                R.drawable.pokemon___hoenn_starters_by_quas_quas_da42wmh_375w_2x
            ),
            GenMenu(4,
                "Generation IV",
                R.drawable.pokemon___sinnoh_starters_by_quas_quas_da4bn4w_375w_2x
            ),
            GenMenu(5,
                "Generation V",
                R.drawable.pokemon___unova_starters_by_quas_quas_da3vcdd_375w_2x
            ),
            GenMenu(6,
                "Generation VI",
                R.drawable.pokemon___kalos_starters_by_quas_quas_da4ci45_375w_2x
            ),
            GenMenu(7,
                "Generation VII",
                R.drawable.pokemon___alola_starters_by_quas_quas_da351uz_375w_2x
            ),

            )
    }
}