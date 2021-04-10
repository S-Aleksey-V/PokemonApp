package me.tolkstudio.pokemonapp.mvp.presenter

import com.github.terrakok.cicerone.Router
import me.tolkstudio.pokemonapp.mvp.navigation.IScreens
import me.tolkstudio.pokemonapp.mvp.view.MainView
import moxy.MvpPresenter
import javax.inject.Inject

class MainPresenter() : MvpPresenter<MainView>() {

    @Inject
    lateinit var router: Router

    @Inject
    lateinit var screens: IScreens

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.replaceScreen(screens.pokemons())
    }

    fun backClicked() {
        router.exit()
    }
}