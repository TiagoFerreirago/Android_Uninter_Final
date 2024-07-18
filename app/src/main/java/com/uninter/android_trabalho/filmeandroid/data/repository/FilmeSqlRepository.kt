package com.uninter.android_trabalho.filmeandroid.data.repository

import android.app.Application
import androidx.room.Room
import com.uninter.android_trabalho.filmeandroid.data.repository.room.FilmeDataBase
import com.uninter.android_trabalho.filmeandroid.domain.entities.Filme

class FilmeSqlRepository(application: Application) {

    companion object{
        var database : FilmeDataBase? = null;

    }

    init {
        database = Room.databaseBuilder(application, FilmeDataBase::class.java, "filme_db")
            .allowMainThreadQueries().build()
    }

    fun add (filme : Filme){
        database?.filmeDao()?.insert(filme)
    }
    fun delete (filme : Filme){
        database?.filmeDao()?.delete(filme);
    }
    fun get() : List<Filme>{
        return database?.filmeDao()?.get()!!
    }
}