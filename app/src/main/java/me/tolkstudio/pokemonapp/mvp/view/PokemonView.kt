package me.tolkstudio.pokemonapp.mvp.view

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface PokemonView : MvpView {
    fun setName(text: String)
    fun loadAvatar(url: String)
    fun setDescription(text: String)
    fun setHp(text: Int)
    fun setAttack(text: Int)
    fun setDefense(text: Int)
    fun setSpecialAttack(text: Int)
    fun setSpecialDefense(text: Int)
    fun setSpeed(text: Int)
}