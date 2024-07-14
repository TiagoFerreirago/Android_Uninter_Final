package com.uninter.android_trabalho.filmeandroid.presentation.view

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.uninter.android_trabalho.R
import com.uninter.android_trabalho.filmeandroid.domain.entities.Filme
import com.uninter.android_trabalho.filmeandroid.domain.entities.entitie

class FilmeAdapter(private val itemList : List<Filme>) :RecyclerView.Adapter<FilmeAdapter.FilmeViewHolder>() {

    class FilmeViewHolder(val item : View) :RecyclerView.ViewHolder(item){
        private val basepath = "https://image.tmdb.org/t/p/w500";
        fun bindView(filme: Filme) {
            with(item){


                var imgfundo = findViewById<ImageView>(R.id.img_capa_id)

                Glide.with(this).load("${basepath}${filme.backdroppath}").into(imgfundo)

                findViewById<ImageView>(R.id.favorito_id).visibility= if(filme.favorite) View.VISIBLE else View.GONE

                item.setOnClickListener(){
                    val intent = Intent(it.context, FilmeDetailActivity::class.java)
                    intent.putExtra("filme", filme)
                    it.context.startActivity(intent)

                }

            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_card_site, parent, false)
        return  FilmeViewHolder(view)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: FilmeViewHolder, position: Int) {
       val item = itemList[position]
        holder.bindView(item)

    }
}