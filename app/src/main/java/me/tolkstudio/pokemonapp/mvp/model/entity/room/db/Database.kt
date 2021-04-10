package me.tolkstudio.pokemonapp.mvp.model.entity.room.db

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import me.tolkstudio.pokemonapp.mvp.model.entity.room.RoomPokemon
import me.tolkstudio.pokemonapp.mvp.model.entity.room.dao.PokemonDao
import java.lang.IllegalStateException

@androidx.room.Database(entities = [RoomPokemon::class], version = 1)

abstract class Database : RoomDatabase() {
    abstract val pokemonDao: PokemonDao

    companion object {
        const val DB_NAME = "database.db"
        private var instance: Database? = null
        fun getInstance() = instance ?: throw IllegalStateException("Database has not been created")
        fun create(context: Context) {
            if (instance == null) {
                instance = Room.databaseBuilder(context, Database::class.java, DB_NAME).build()
            }
        }
    }
}