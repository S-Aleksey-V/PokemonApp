package me.tolkstudio.pokemonapp.mvp.model.entity.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class RoomPokemon(
    @PrimaryKey val name: String,
    val xdescription: String,
    val imageurl: String,
    val hp: Int,
    val attack: Int,
    val defense: Int,
    val special_attack: Int,
    val special_defense: Int,
    val speed: Int,
)