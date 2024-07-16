package com.uninter.android_trabalho.filmeandroid.data.client

import com.uninter.android_trabalho.filmeandroid.data.model.FilmeResult
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ITheMovieDbCliente {
    @GET("3/movie/popular")
    fun getTvPopular(@Query("api_key") apiKey : String) : Call<FilmeResult>
}