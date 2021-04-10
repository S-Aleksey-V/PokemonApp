package me.tolkstudio.pokemonapp.mvp.model.repo

import io.reactivex.rxjava3.core.Single
import me.tolkstudio.pokemonapp.mvp.model.entity.Pokemon

interface IPokemonsRepo {
    fun getPokemons(): Single<List<Pokemon>>
}