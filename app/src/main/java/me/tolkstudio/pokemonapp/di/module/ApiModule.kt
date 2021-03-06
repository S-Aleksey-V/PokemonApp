package me.tolkstudio.pokemonapp.di.module

import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import me.tolkstudio.pokemonapp.ui.App
import me.tolkstudio.pokemonapp.ui.network.AndroidNetworkStatus
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import me.tolkstudio.pokemonapp.mvp.model.api.IDataSource
import me.tolkstudio.pokemonapp.mvp.model.network.INetworkStatus

@Module
class ApiModule {

    @Provides
    fun api(gson: Gson): IDataSource = Retrofit.Builder()
        .baseUrl("https://gist.githubusercontent.com/")
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()
        .create(IDataSource::class.java)

    @Provides
    fun gson(): Gson = GsonBuilder()
        .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
        .excludeFieldsWithoutExposeAnnotation()
        .create()

    @Provides
    fun networkStatus(app: App): INetworkStatus = AndroidNetworkStatus(app)
}