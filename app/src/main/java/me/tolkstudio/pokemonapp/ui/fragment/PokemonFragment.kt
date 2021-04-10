package me.tolkstudio.pokemonapp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import me.tolkstudio.pokemonapp.databinding.FragmentPokemonBinding
import me.tolkstudio.pokemonapp.mvp.model.entity.Pokemon
import me.tolkstudio.pokemonapp.mvp.presenter.PokemonPresenter
import me.tolkstudio.pokemonapp.mvp.view.PokemonView
import me.tolkstudio.pokemonapp.ui.App
import me.tolkstudio.pokemonapp.ui.BackButtonListener
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import me.tolkstudio.pokemonapp.mvp.model.image.IImageLoader
import ru.geekbrains.geekbrains_popular_libraries_kotlin.ui.image.GlideImageLoader

class PokemonFragment(val imageLoader: IImageLoader<ImageView>) : MvpAppCompatFragment(),
    PokemonView, BackButtonListener {

    companion object {
        private const val POKEMON_ARG = "pokemon"

        fun newInstance(pokemon: Pokemon) = PokemonFragment(GlideImageLoader()).apply {
            arguments = Bundle().apply {
                putParcelable(POKEMON_ARG, pokemon)
            }
        }
    }

    val presenter: PokemonPresenter by moxyPresenter {
        val pokemon = arguments?.getParcelable<Pokemon>(POKEMON_ARG) as Pokemon
        PokemonPresenter(pokemon).apply { App.instance.appComponent.inject(this) }
    }

    private var vb: FragmentPokemonBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) =
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

    override fun loadAvatar(url: String) = with(vb) {
        imageLoader.load(url, this!!.pkAvatar)
    }

    override fun setDescription(text: String) {
        vb?.pkDescription?.text = text
    }

    override fun setHp(text: Int) {
        vb?.pkHP?.text = text.toString()
        vb?.progressBarHP?.setProgress(text, true)
    }

    override fun setAttack(text: Int) {
        vb?.pkAttack?.text = text.toString()
        vb?.progressBarAttack?.setProgress(text, true)
    }

    override fun setDefense(text: Int) {
        vb?.pkDefense?.text = text.toString()
        vb?.progressBarDefense?.setProgress(text, true)
    }

    override fun setSpecialAttack(text: Int) {
        vb?.pkSpAtk?.text = text.toString()
        vb?.progressBarSpAtk?.setProgress(text, true)
    }

    override fun setSpecialDefense(text: Int) {
        vb?.pkSpDef?.text = text.toString()
        vb?.progressBarSpDef?.setProgress(text, true)
    }

    override fun setSpeed(text: Int) {
        vb?.pkSpeed?.text = text.toString()
        vb?.progressBarSpeed?.setProgress(text, true)
    }


    override fun backPressed() = presenter.backPressed()


}