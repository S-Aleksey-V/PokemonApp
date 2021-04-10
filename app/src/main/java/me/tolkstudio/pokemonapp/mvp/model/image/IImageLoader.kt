package me.tolkstudio.pokemonapp.mvp.model.image

interface IImageLoader<T> {
    fun load(url: String, container: T)
}