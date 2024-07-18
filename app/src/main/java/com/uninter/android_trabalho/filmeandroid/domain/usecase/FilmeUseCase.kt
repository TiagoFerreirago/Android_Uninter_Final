package com.uninter.android_trabalho.filmeandroid.domain.usecase

import android.app.Application
import com.uninter.android_trabalho.filmeandroid.data.repository.FilmeAPIRepository
import com.uninter.android_trabalho.filmeandroid.data.repository.FilmeSqlRepository
import com.uninter.android_trabalho.filmeandroid.domain.entities.Filme
import java.lang.Appendable

class FilmeUseCase(application: Application) {

    private val apiRepository = FilmeAPIRepository;
    private val sqlRepository = FilmeSqlRepository(application);


    fun get(): List<Filme> {

        var listaSeriesDb: List<Filme> = listOf()

        sqlRepository.get()?.let {
            listaSeriesDb = listaSeriesDb.plus(it)
        }

        apiRepository.get()?.let {
            var lista = it.toMutableList()
            lista.removeAll { filme -> listaSeriesDb.any { filmeDb -> filmeDb.id == filme.id }
            }
            listaSeriesDb = listaSeriesDb.plus(lista);


        }
        return listaSeriesDb;
    }

    fun favorite(filme : Filme){
        filme.favorite = true
        sqlRepository.add(filme);
    }

    fun unfavorite(filme : Filme){
        sqlRepository.delete((filme))
    }
}
