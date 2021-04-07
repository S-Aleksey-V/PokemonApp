package me.tolkstudio.pokemonapp.mvp.model.repo

import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import me.tolkstudio.pokemonapp.mvp.model.entity.Pokemon
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.model.api.IDataSource

class RetrofitPokemonsRepo(val api: IDataSource) : IPokemonsRepo {
    override fun getPokemons() = api.getPokemon().subscribeOn(Schedulers.io())
}