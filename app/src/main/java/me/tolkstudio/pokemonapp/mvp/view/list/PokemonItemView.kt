package me.tolkstudio.pokemonapp.mvp.view.list

interface PokemonItemView : IItemView {
    fun setName(text: String)
    fun loadAvatar(url: String)

}