package com.uninter.android_trabalho.filmeandroid.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.uninter.android_trabalho.filmeandroid.domain.entities.Filme
import com.uninter.android_trabalho.filmeandroid.domain.usecase.FilmeUseCase
import kotlin.concurrent.thread

class MainViewModel(application: Application) : ViewModel() {

    private val  useCase = FilmeUseCase(application)
    var listFilme = MutableLiveData<List<Filme>>()

    fun load(){
        Thread(Runnable{
            listFilme.postValue(useCase.get())
        }).start()

    }
}