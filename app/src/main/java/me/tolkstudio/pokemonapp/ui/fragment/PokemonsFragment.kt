package me.tolkstudio.pokemonapp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import me.tolkstudio.pokemonapp.databinding.FragmentPokemonsBinding
import me.tolkstudio.pokemonapp.mvp.presenter.PokemonsPresenter
import me.tolkstudio.pokemonapp.mvp.view.PokemonsView
import me.tolkstudio.pokemonapp.ui.App
import me.tolkstudio.pokemonapp.ui.BackButtonListener
import me.tolkstudio.pokemonapp.ui.adapter.PokemonsRVAdapter
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import ru.geekbrains.geekbrains_popular_libraries_kotlin.ui.image.GlideImageLoader

class PokemonsFragment : MvpAppCompatFragment(), PokemonsView, BackButtonListener {
    companion object {
        fun newInstance() = PokemonsFragment()
    }

    val presenter: PokemonsPresenter by moxyPresenter {
        PokemonsPresenter(
            AndroidSchedulers.mainThread()
        ).apply { App.instance.appComponent.inject(this) }
    }

    var adapter: PokemonsRVAdapter? = null

    private var vb: FragmentPokemonsBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) =
        FragmentPokemonsBinding.inflate(inflater, container, false).also {
            vb = it
        }.root

    override fun onDestroyView() {
        super.onDestroyView()
        vb = null
    }

    override fun init() {
        vb?.rvPokemons?.layoutManager = GridLayoutManager(context, 2)
        adapter = PokemonsRVAdapter(presenter.pokemonListPresenter, GlideImageLoader())
        vb?.rvPokemons?.adapter = adapter
    }

    override fun updateList() {
        adapter?.notifyDataSetChanged()
    }

    override fun backPressed() = presenter.backPressed()
}