package me.tolkstudio.pokemonapp.ui

import android.app.Application
import me.tolkstudio.pokemonapp.di.AppComponent
import me.tolkstudio.pokemonapp.di.DaggerAppComponent
import me.tolkstudio.pokemonapp.di.module.AppModule
import me.tolkstudio.pokemonapp.mvp.model.entity.room.db.Database

class App : Application() {
    companion object {
        lateinit var instance: App
    }

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        instance = this
        Database.create(this)

        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
    }
}