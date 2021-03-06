package me.tolkstudio.pokemonapp.mvp.model.entity

import android.os.Parcelable
import com.google.gson.annotations.Expose
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Pokemon(
    @Expose val name: String,
    @Expose val xdescription: String,
    @Expose val imageurl: String,
    @Expose val hp: Int,
    @Expose val attack: Int,
    @Expose val defense: Int,
    @Expose val special_attack: Int,
    @Expose val special_defense: Int,
    @Expose val speed: Int,
) : Parcelable
