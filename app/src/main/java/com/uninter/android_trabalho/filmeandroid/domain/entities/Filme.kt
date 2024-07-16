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
    @SerializedName("original_language")
    val originalLanguage : String,
    @ColumnInfo("Titulo")
    val title : String,
    @ColumnInfo("Texto")
    val overview : String,

    @ColumnInfo("Lançamento")
    @SerializedName("release_date")
    val releaseDate : String,
    @ColumnInfo("Media_Votos")
    @SerializedName("vote_average")
    val voteAverage : Float,
    @ColumnInfo("Votos_Totais")
    @SerializedName("vote_count")
    val voteCount : Int,
    @ColumnInfo("Poster_path")
    @SerializedName("poster_path")
    val posterPath : String,
    @ColumnInfo("Backdrop_path")
    @SerializedName("backdrop_path")
    val backdropPath : String,
    var favorite : Boolean

) : Serializable {
}