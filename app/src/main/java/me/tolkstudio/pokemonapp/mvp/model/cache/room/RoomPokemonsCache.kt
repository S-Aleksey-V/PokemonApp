package me.tolkstudio.pokemonapp.mvp.model.cache.room

import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import me.tolkstudio.pokemonapp.mvp.model.cache.IPokemonsCache
import me.tolkstudio.pokemonapp.mvp.model.entity.Pokemon
import me.tolkstudio.pokemonapp.mvp.model.entity.room.RoomPokemon
import me.tolkstudio.pokemonapp.mvp.model.entity.room.db.Database

class RoomPokemonsCache(val db: Database) : IPokemonsCache {

    override fun getPokemons() = Single.fromCallable {
        db.pokemonDao.getAll().map { roomPokemon ->
            Pokemon(
                roomPokemon.name,
                roomPokemon.xdescription,
                roomPokemon.imageurl,
                roomPokemon.hp,
                roomPokemon.attack,
                roomPokemon.defense,
                roomPokemon.special_attack,
                roomPokemon.special_defense,
                roomPokemon.speed
            )
        }
    }

    override fun putPokemons(pokemons: List<Pokemon>) = Completable.fromAction {
        val roomPokemons = pokemons.map { pokemon ->
            RoomPokemon(
                pokemon.name,
                pokemon.xdescription,
                pokemon.imageurl,
                pokemon.hp,
                pokemon.attack,
                pokemon.defense,
                pokemon.special_attack,
                pokemon.special_defense,
                pokemon.speed
            )
        }
        db.pokemonDao.insert(roomPokemons)
    }.subscribeOn(Schedulers.io())
}