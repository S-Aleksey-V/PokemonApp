package me.tolkstudio.pokemonapp.mvp.presenter

import com.bumptech.glide.Glide
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.disposables.CompositeDisposable
import me.tolkstudio.pokemonapp.mvp.model.entity.Pokemon
import me.tolkstudio.pokemonapp.mvp.model.navigation.IScreens
import me.tolkstudio.pokemonapp.mvp.model.repo.IPokemonsRepo
import me.tolkstudio.pokemonapp.mvp.model.repo.RetrofitPokemonsRepo
import me.tolkstudio.pokemonapp.mvp.presenter.list.IPokemonListPresenter
import me.tolkstudio.pokemonapp.mvp.view.PokemonsView
import me.tolkstudio.pokemonapp.mvp.view.list.PokemonItemView
import moxy.MvpPresenter

class PokemonsPresenter(
    val pokemonsRepo: IPokemonsRepo,
    val router: Router,
    val screens: IScreens,
    val uiScheduler: Scheduler
) : MvpPresenter<PokemonsView>() {
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

    val compositeDisposable = CompositeDisposable()

    val usersListPresenter = PokemonsListPresenter()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        loadData()

        usersListPresenter.itemClickListener = { itemView ->
            val pokemon = usersListPresenter.pokemons[itemView.pos]
            router.navigateTo(screens.pokemon(pokemon))
        }
    }

    fun loadData() {
        val disposable = pokemonsRepo.getPokemons()
            .observeOn(uiScheduler)
            .subscribe({
                usersListPresenter.pokemons.addAll(it)
                viewState.updateList()
            }, {
                it.printStackTrace()
            })

        compositeDisposable.add(disposable)
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }

    override fun onDestroy() {
        compositeDisposable.dispose()
        super.onDestroy()
    }

}