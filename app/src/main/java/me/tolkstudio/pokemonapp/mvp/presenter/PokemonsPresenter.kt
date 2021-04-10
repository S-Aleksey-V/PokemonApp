package me.tolkstudio.pokemonapp.mvp.presenter

import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.core.Scheduler
import me.tolkstudio.pokemonapp.mvp.model.entity.Pokemon
import me.tolkstudio.pokemonapp.mvp.navigation.IScreens
import me.tolkstudio.pokemonapp.mvp.model.repo.IPokemonsRepo
import me.tolkstudio.pokemonapp.mvp.presenter.list.IPokemonListPresenter
import me.tolkstudio.pokemonapp.mvp.view.PokemonsView
import me.tolkstudio.pokemonapp.mvp.view.list.PokemonItemView
import moxy.MvpPresenter
import javax.inject.Inject

class PokemonsPresenter(
    val uiScheduler: Scheduler
) : MvpPresenter<PokemonsView>() {

    @Inject
    lateinit var pokemonsRepo: IPokemonsRepo

    @Inject
    lateinit var screens: IScreens

    @Inject
    lateinit var router: Router

    class PokemonsListPresenter : IPokemonListPresenter {
        val pokemons = mutableListOf<Pokemon>()

        override var itemClickListener: ((PokemonItemView) -> Unit)? = null

        override fun getCount() = pokemons.size

        override fun bindView(view: PokemonItemView) {
            val pokemon = pokemons[view.pos]
            view.setName(pokemon.name)
            view.loadAvatar(pokemon.imageurl)
        }
    }

    val pokemonListPresenter = PokemonsListPresenter()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        loadData()

        pokemonListPresenter.itemClickListener = { itemView ->
            val pokemon = pokemonListPresenter.pokemons[itemView.pos]
            router.navigateTo(screens.pokemon(pokemon))
        }
    }

    fun loadData() {
        pokemonsRepo.getPokemons()
            .observeOn(uiScheduler)
            .subscribe({
                pokemonListPresenter.pokemons.addAll(it)
                viewState.updateList()
            },
                { it.printStackTrace() })
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }
}