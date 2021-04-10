package me.tolkstudio.pokemonapp.mvp.model.entity.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import me.tolkstudio.pokemonapp.mvp.model.entity.room.RoomPokemon

@Dao
interface PokemonDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(users: List<RoomPokemon>)

    @Query("SELECT * FROM RoomPokemon")
    fun getAll(): List<RoomPokemon>

    @Query("SELECT * FROM RoomPokemon WHERE name = :name LIMIT 1")
    fun findByLogin(name: String): RoomPokemon?
}