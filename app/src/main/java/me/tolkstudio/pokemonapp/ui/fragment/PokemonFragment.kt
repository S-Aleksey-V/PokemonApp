package me.tolkstudio.pokemonapp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import me.tolkstudio.pokemonapp.databinding.FragmentPokemonBinding
import me.tolkstudio.pokemonapp.mvp.model.entity.Pokemon
import me.tolkstudio.pokemonapp.mvp.presenter.PokemonPresenter
import me.tolkstudio.pokemonapp.mvp.view.PokemonView
import me.tolkstudio.pokemonapp.ui.App
import me.tolkstudio.pokemonapp.ui.BackButtonListener
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class PokemonFragment : MvpAppCompatFragment(), PokemonView, BackButtonListener {

    companion object {
        private const val POKEMON_ARG = "pokemon"

        fun newInstance(pokemon: Pokemon) = PokemonFragment().apply {
            arguments = Bundle().apply {
                putParcelable(POKEMON_ARG, pokemon)
            }
        }
    }

    val presenter: PokemonPresenter by moxyPresenter {
        val pokemon = arguments?.getParcelable<Pokemon>(POKEMON_ARG) as Pokemon //При отсутствии аргумента приложение упадет. Так задумано.
        PokemonPresenter(App.instance.router, pokemon)
    }

    private var vb: FragmentPokemonBinding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
        FragmentPokemonBinding.inflate(inflater, container, false).also {
            vb = it
        }.root

    override fun onDestroyView() {
        super.onDestroyView()
        vb = null
    }

    override fun setName(text: String) {
        vb?.pkName?.text = text
    }


    override fun backPressed() = presenter.backPressed()


}