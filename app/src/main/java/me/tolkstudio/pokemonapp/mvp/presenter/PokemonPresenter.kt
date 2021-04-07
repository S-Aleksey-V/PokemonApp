package me.tolkstudio.pokemonapp.mvp.presenter

import com.github.terrakok.cicerone.Router
import me.tolkstudio.pokemonapp.mvp.model.entity.Pokemon
import me.tolkstudio.pokemonapp.mvp.view.PokemonView
import moxy.MvpPresenter

class PokemonPresenter(val router: Router, val pokemon: Pokemon) : MvpPresenter<PokemonView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.setName(pokemon.name)
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }
}