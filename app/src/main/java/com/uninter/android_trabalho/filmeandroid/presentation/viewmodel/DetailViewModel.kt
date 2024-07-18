package com.uninter.android_trabalho.filmeandroid.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import com.uninter.android_trabalho.filmeandroid.domain.entities.Filme
import com.uninter.android_trabalho.filmeandroid.domain.usecase.FilmeUseCase

class DetailViewModel(application: Application) : ViewModel() {

    var useCase = FilmeUseCase(application)

    fun favorite(filme : Filme){
        useCase.favorite(filme)
    }

    fun unfavorite(filme : Filme){
        useCase.unfavorite(filme)
    }
}
