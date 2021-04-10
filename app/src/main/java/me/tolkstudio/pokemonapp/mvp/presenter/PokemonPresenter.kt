package me.tolkstudio.pokemonapp.mvp.presenter

import com.github.terrakok.cicerone.Router
import me.tolkstudio.pokemonapp.mvp.model.entity.Pokemon
import me.tolkstudio.pokemonapp.mvp.view.PokemonView
import moxy.MvpPresenter
import javax.inject.Inject

class PokemonPresenter(val pokemon: Pokemon) : MvpPresenter<PokemonView>() {

    @Inject
    lateinit var router: Router

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.setName(pokemon.name)
        viewState.loadAvatar(pokemon.imageurl)
        viewState.setDescription(pokemon.xdescription)
        viewState.setHp(pokemon.hp)
        viewState.setAttack(pokemon.attack)
        viewState.setDefense(pokemon.defense)
        viewState.setSpecialAttack(pokemon.special_attack)
        viewState.setSpecialDefense(pokemon.special_defense)
        viewState.setSpeed(pokemon.speed)
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }
}