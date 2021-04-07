package me.tolkstudio.pokemonapp.mvp.model.entity

import android.os.Parcelable
import com.google.gson.annotations.Expose
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Pokemon(
    @Expose val name: String,
    @Expose val imageurl: String
) : Parcelable
