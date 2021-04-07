package me.tolkstudio.pokemonapp.ui.navigation

import com.github.terrakok.cicerone.androidx.FragmentScreen
import me.tolkstudio.pokemonapp.mvp.model.entity.Pokemon
import me.tolkstudio.pokemonapp.mvp.model.navigation.IScreens
import me.tolkstudio.pokemonapp.ui.fragment.PokemonFragment
import me.tolkstudio.pokemonapp.ui.fragment.PokemonsFragment

class AndroidScreens: IScreens {
    override fun pokemons() = FragmentScreen{PokemonsFragment.newInstance()}

    override fun pokemon(pokemon: Pokemon) = FragmentScreen{PokemonFragment.newInstance(pokemon)}

}