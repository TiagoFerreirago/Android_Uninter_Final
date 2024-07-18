package com.uninter.android_trabalho.filmeandroid.data.repository.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.uninter.android_trabalho.filmeandroid.domain.entities.Filme

@Dao
interface IFilmeDao {
    @Query("SELECT * FROM Filmes")
    fun get() : List<Filme>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg filme : Filme)
    @Delete
    fun delete(filme : Filme)
}