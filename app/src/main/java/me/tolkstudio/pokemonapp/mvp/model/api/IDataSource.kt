package me.tolkstudio.pokemonapp.mvp.model.api


import io.reactivex.rxjava3.core.Single
import me.tolkstudio.pokemonapp.mvp.model.entity.Pokemon
import retrofit2.http.GET

interface IDataSource {

    @GET("S-Aleksey-V/16303d39e36655d62d8461a143e98d31/raw/97811a5df2df7304b5bc4fbb9ee018a0339b8a38/pokemon.json")
    fun getPokemon(): Single<List<Pokemon>>

}