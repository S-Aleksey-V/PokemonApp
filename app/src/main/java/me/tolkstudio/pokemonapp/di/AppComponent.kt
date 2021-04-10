package me.tolkstudio.pokemonapp.di

import dagger.Component
import me.tolkstudio.pokemonapp.di.module.*
import me.tolkstudio.pokemonapp.mvp.presenter.MainPresenter
import me.tolkstudio.pokemonapp.mvp.presenter.PokemonPresenter
import me.tolkstudio.pokemonapp.mvp.presenter.PokemonsPresenter
import me.tolkstudio.pokemonapp.ui.activity.MainActivity
import me.tolkstudio.pokemonapp.ui.adapter.PokemonsRVAdapter

import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        CiceroneModule::class,
        ApiModule::class,
        RepoModule::class,
        CacheModule::class
    ]
)
interface AppComponent {

    fun inject(mainActivity: MainActivity)
    fun inject(mainPresenter: MainPresenter)
    fun inject(usersPresenter: PokemonPresenter)
    fun inject(usersRVAdapter: PokemonsRVAdapter)
    fun inject(userInfoPresenter: PokemonsPresenter)


}