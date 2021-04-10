package me.tolkstudio.pokemonapp.mvp.model.repo

import io.reactivex.rxjava3.schedulers.Schedulers
import me.tolkstudio.pokemonapp.mvp.model.cache.IPokemonsCache
import me.tolkstudio.pokemonapp.mvp.model.api.IDataSource
import me.tolkstudio.pokemonapp.mvp.model.network.INetworkStatus

class RetrofitPokemonsRepo(
    val api: IDataSource,
    val networkStatus: INetworkStatus,
    val cache: IPokemonsCache
) : IPokemonsRepo {
    override fun getPokemons() = networkStatus.isOnlineSingle().flatMap { isOnline ->
        if (isOnline) {
            api.getPokemon()
                .flatMap { pokemons ->
                    cache.putPokemons(pokemons).toSingleDefault(pokemons)
                }
        } else {
            cache.getPokemons()
        }
    }.subscribeOn(Schedulers.io())

}