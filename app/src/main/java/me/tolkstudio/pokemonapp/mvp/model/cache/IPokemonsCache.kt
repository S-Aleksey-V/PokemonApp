package me.tolkstudio.pokemonapp.mvp.model.cache

import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import me.tolkstudio.pokemonapp.mvp.model.entity.Pokemon

interface IPokemonsCache {
    fun getPokemons(): Single<List<Pokemon>>
    fun putPokemons(pokemons: List<Pokemon>): Completable
}