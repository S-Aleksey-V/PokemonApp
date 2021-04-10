package me.tolkstudio.pokemonapp.di.module

import androidx.room.Room
import dagger.Module
import dagger.Provides
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Scheduler
import me.tolkstudio.pokemonapp.mvp.model.cache.IPokemonsCache
import me.tolkstudio.pokemonapp.mvp.model.cache.room.RoomPokemonsCache
import me.tolkstudio.pokemonapp.mvp.model.entity.room.db.Database
import me.tolkstudio.pokemonapp.ui.App
import javax.inject.Named
import javax.inject.Singleton

@Module
class CacheModule {

    @Singleton
    @Provides
    fun database(app: App) =
        Room.databaseBuilder(app, Database::class.java, Database.DB_NAME).build()

    @Singleton
    @Provides
    fun usersCache(db: Database): IPokemonsCache = RoomPokemonsCache(db)

    @Named("ui")
    @Provides
    fun uiScheduler(): Scheduler = AndroidSchedulers.mainThread()

}