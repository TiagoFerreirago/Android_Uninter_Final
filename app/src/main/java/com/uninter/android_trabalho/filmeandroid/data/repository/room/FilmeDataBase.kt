package com.uninter.android_trabalho.filmeandroid.data.repository.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.uninter.android_trabalho.filmeandroid.domain.entities.Filme

@Database(version = 1 , entities = [Filme::class])
abstract class FilmeDataBase : RoomDatabase() {
    abstract fun filmeDao() : IFilmeDao
}