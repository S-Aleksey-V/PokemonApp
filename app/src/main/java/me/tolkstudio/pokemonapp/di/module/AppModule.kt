package me.tolkstudio.pokemonapp.di.module

import dagger.Module
import dagger.Provides
import me.tolkstudio.pokemonapp.ui.App

@Module
class AppModule(val app: App) {

    @Provides
    fun app(): App = app
}