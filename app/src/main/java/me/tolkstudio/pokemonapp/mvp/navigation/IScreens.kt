package me.tolkstudio.pokemonapp.mvp.navigation

import com.github.terrakok.cicerone.Screen
import me.tolkstudio.pokemonapp.mvp.model.entity.Pokemon

interface IScreens {
    fun pokemons(): Screen
    fun pokemon(pokemon: Pokemon): Screen
}