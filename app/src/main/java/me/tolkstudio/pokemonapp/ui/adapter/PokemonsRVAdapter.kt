package me.tolkstudio.pokemonapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import me.tolkstudio.pokemonapp.databinding.ItemPokemonBinding
import me.tolkstudio.pokemonapp.mvp.presenter.list.IPokemonListPresenter
import me.tolkstudio.pokemonapp.mvp.view.list.PokemonItemView
import me.tolkstudio.pokemonapp.mvp.model.image.IImageLoader

class PokemonsRVAdapter(
    val presenter: IPokemonListPresenter,
    val imageLoader: IImageLoader<ImageView>
) :
    RecyclerView.Adapter<PokemonsRVAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            ItemPokemonBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        ).apply {
            itemView.setOnClickListener { presenter.itemClickListener?.invoke(this) }
        }

    override fun getItemCount() = presenter.getCount()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        presenter.bindView(holder.apply { pos = position })

    inner class ViewHolder(val vb: ItemPokemonBinding) : RecyclerView.ViewHolder(vb.root),
        PokemonItemView {

        override fun setName(text: String) = with(vb) {
            pokemonName.text = text
        }

        override fun loadAvatar(url: String) = with(vb) {
            imageLoader.load(url, ivAvatar)
        }

        override var pos = -1
    }
}