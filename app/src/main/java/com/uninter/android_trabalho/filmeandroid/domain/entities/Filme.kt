package com.uninter.android_trabalho.filmeandroid.domain.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable
@Entity(tableName = "Filmes")
data class Filme(
    @PrimaryKey
    val id : Int,
    @ColumnInfo("Linguagem")
    val originallanguage : String,
    @ColumnInfo("Titulo")
    val title : String,
    @ColumnInfo("Texto")
    val text : String,
    @ColumnInfo("Lançamento")
    val releasedate : String,
    @ColumnInfo("Media_Votos")
    val voteaverage : Float,
    @ColumnInfo("Votos_Totais")
    val votecount : Int,
    @ColumnInfo("Poster_path")
    @SerializedName("poster_path")
    val posterpath : String,
    @ColumnInfo("Backdrop_path")
    @SerializedName("backdrop_path")
    val backdroppath : String,
    var favorite : Boolean

) : Serializable {
}