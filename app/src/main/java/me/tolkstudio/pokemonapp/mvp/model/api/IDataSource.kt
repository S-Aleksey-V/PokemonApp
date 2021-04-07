package ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.model.api

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import me.tolkstudio.pokemonapp.mvp.model.entity.Pokemon
import retrofit2.http.GET


interface IDataSource {

    @GET("mrcsxsiq/b94dbe9ab67147b642baa9109ce16e44/raw/97811a5df2df7304b5bc4fbb9ee018a0339b8a38")
    fun getPokemon(): Single<List<Pokemon>>

}