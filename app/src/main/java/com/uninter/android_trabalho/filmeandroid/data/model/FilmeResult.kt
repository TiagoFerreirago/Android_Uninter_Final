package com.uninter.android_trabalho.filmeandroid.data.model

import com.google.gson.annotations.SerializedName
import com.uninter.android_trabalho.filmeandroid.domain.entities.Filme

data class FilmeResult(
    val page : Int,
    val results : List<Filme>,
    @SerializedName("total_pages")
    val totalPages : Int,
    @SerializedName("total_results")
    val totalResult : Int
) {




}