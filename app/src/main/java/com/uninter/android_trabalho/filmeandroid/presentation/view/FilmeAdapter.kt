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
import com.uninter.android_trabalho.filmeandroid.data.repository.FilmeAPIRepository
import com.uninter.android_trabalho.filmeandroid.domain.entities.Filme
import com.uninter.android_trabalho.filmeandroid.domain.entities.entitie
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FilmeAdapter(private val itemList : List<Filme>) :RecyclerView.Adapter<FilmeAdapter.ViewHolder>() {

    class ViewHolder(val item : View) :RecyclerView.ViewHolder(item){
        private val basepath = "https://image.tmdb.org/t/p/w500";
        //imagem da capa
        private val imgFundo: ImageView = item.findViewById(R.id.img_capa_id)
        private val imgFundo2: ImageView = item.findViewById(R.id.img_capa_id2)
        fun bindView(filme: Filme, filme2 : Filme?) {
            with(item){

                //favoritos da tela principal
                findViewById<ImageView>(R.id.favorito_id).visibility= if(filme.favorite) View.VISIBLE else View.GONE
                //titulo
                findViewById<TextView>(R.id.txt_titulo_id).text = filme.title
                Glide.with(item.context).load("${basepath}${filme.backdropPath}").into(imgFundo)

                item.setOnClickListener(){
                    val intent = Intent(it.context, FilmeDetailActivity::class.java)
                    intent.putExtra("filme", filme)
                    it.context.startActivity(intent)

                }
                Glide.with(item.context).load("$basepath${filme2?.backdropPath}").into(imgFundo2)
                imgFundo2.setOnClickListener {
                    val intent = Intent(it.context, FilmeDetailActivity::class.java)
                    intent.putExtra("filme", filme2)
                    it.context.startActivity(intent)
                }


            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_card_site, parent, false)
        return  ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return (itemList.size + 1)/2
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val posIndex = position * 2
        val filme = itemList[posIndex]
        val filme2 = if(posIndex + 1 <= itemList.size) itemList[posIndex + 1] else null
        holder.bindView(filme,filme2)


    }

}