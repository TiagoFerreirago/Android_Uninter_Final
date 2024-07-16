package com.uninter.android_trabalho.filmeandroid.data.repository

import android.util.Log
import com.uninter.android_trabalho.filmeandroid.data.client.ITheMovieDbCliente
import com.uninter.android_trabalho.filmeandroid.domain.entities.Filme
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object FilmeAPIRepository {

    private val theMovieDbCliente : ITheMovieDbCliente;
    private val apiKey = "045acca0d22736aa7ab42328c8ec445b";
    init{
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(OkHttpClient()).build();

        theMovieDbCliente = retrofit.create(ITheMovieDbCliente::class.java)
        }
    fun get() : List<Filme>?
    {
        try
        {
            val call = theMovieDbCliente.getTvPopular(apiKey)
            return call.execute().body()?.results
        }
        catch(ex : Exception){

            Log.e("FilmeAPIRepository", ex.message.toString())
            return null;
        }
    }
}