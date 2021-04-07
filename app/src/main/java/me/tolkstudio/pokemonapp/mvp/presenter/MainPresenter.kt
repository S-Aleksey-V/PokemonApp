package me.tolkstudio.pokemonapp.mvp.presenter

import com.github.terrakok.cicerone.Router
import me.tolkstudio.pokemonapp.mvp.model.navigation.IScreens
import me.tolkstudio.pokemonapp.mvp.view.MainView
import moxy.MvpPresenter

class MainPresenter(val router: Router, val screens: IScreens) : MvpPresenter<MainView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.replaceScreen(screens.pokemons())

    }

    fun backClicked() {
        router.exit()
    }
}