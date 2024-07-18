package com.uninter.android_trabalho.filmeandroid.presentation.view

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.uninter.android_trabalho.R
import com.uninter.android_trabalho.filmeandroid.domain.entities.Filme
import com.uninter.android_trabalho.filmeandroid.presentation.viewmodel.DetailViewModel
import com.uninter.android_trabalho.filmeandroid.presentation.viewmodel.FilmeViewModelFactory

class FilmeDetailActivity : AppCompatActivity() {

    private lateinit var imgtitulo : ImageView
    private lateinit var txtname : TextView
    private lateinit var txtlinguagem : TextView
    private lateinit var txtmedia : TextView
    private lateinit var txtvotos : TextView
    private lateinit var txtlancamentos : TextView
    private lateinit var imgprincipal : ImageView
    private lateinit var txtprincipal : TextView
    private lateinit var btnfavoritos : Button


    private val basepath = "https://image.tmdb.org/t/p/w500";

    private var filme : Filme? = null;

    val viewModel by lazy{
        var factory = FilmeViewModelFactory(application)
        ViewModelProvider(this, factory)[DetailViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_site_detail)

        filme = intent.getSerializableExtra("filme") as Filme
        bindView()
        }

    fun bindView()
    {
        imgtitulo = findViewById(R.id.img_titulodetail_id)
        txtname = findViewById(R.id.titulo_detail_id)
        txtlinguagem = findViewById(R.id.linguagem_detail_id)
        txtmedia = findViewById(R.id.media_detail_id)
        txtvotos = findViewById(R.id.votos_detail_id)
        txtlancamentos = findViewById(R.id.lancamento_detail_id)
        imgprincipal= findViewById(R.id.img_textodetail_id)
        txtprincipal = findViewById(R.id.txt_descricaodetail_id)
        btnfavoritos = findViewById(R.id.favoritos_detail_id)



        filme?.let{filme ->
            Glide.with(this).load("${basepath}${filme.posterPath}").into(imgtitulo)
            txtname.text = filme.title;
            txtlinguagem.text = filme.originalLanguage;
            txtmedia.text = filme.voteAverage.toString();
            txtvotos.text = filme.voteCount.toString();
            txtlancamentos.text = filme.releaseDate;
            Glide.with(this).load("${basepath}${filme.backdropPath}").into(imgprincipal)
            txtprincipal.text= filme.overview;
            btnfavoritos.text= if(filme.favorite) "Desfavoritar" else "Favoritos"

            btnfavoritos.setOnClickListener{
                if(filme.favorite)
                    unfavorite(filme)

                else
                    favorite(filme)

                finish()
            }
        }

    }

    private fun unfavorite(filme: Filme) {
        viewModel.favorite(filme)
    }
    private fun favorite(filme: Filme) {
        viewModel.unfavorite(filme)
    }


}
