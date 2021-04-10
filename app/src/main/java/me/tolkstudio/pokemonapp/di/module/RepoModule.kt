package me.tolkstudio.pokemonapp.di.module


import dagger.Module
import dagger.Provides
import me.tolkstudio.pokemonapp.mvp.model.cache.IPokemonsCache
import me.tolkstudio.pokemonapp.mvp.model.repo.IPokemonsRepo
import me.tolkstudio.pokemonapp.mvp.model.repo.RetrofitPokemonsRepo
import me.tolkstudio.pokemonapp.mvp.model.api.IDataSource
import me.tolkstudio.pokemonapp.mvp.model.network.INetworkStatus

import javax.inject.Singleton

@Module
class RepoModule {

    @Singleton
    @Provides
    fun usersRepo(
        api: IDataSource,
        networkStatus: INetworkStatus,
        cache: IPokemonsCache
    ): IPokemonsRepo = RetrofitPokemonsRepo(api, networkStatus, cache)

}