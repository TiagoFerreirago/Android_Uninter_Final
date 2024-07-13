package com.uninter.android_trabalho.view

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.uninter.android_trabalho.R
import com.uninter.android_trabalho.entities.entitie

class SiteAdapter(private val itemList : List<entitie>) :RecyclerView.Adapter<SiteAdapter.SiteViewHolder>() {

    class SiteViewHolder(item : View) :RecyclerView.ViewHolder(item){
        private val title : TextView = item.findViewById(R.id.tvTitulo)
        private val subtitulo : TextView = item.findViewById(R.id.tvSubtitulo)
        private val card : CardView = item.findViewById(R.id.cardView)

        fun bindView(newItem : entitie) {
            title.text = newItem.title
            subtitulo.text = newItem.subtitulo

            card.setOnClickListener { infor ->
                val conCard = infor.context
                val intent = Intent(conCard, SiteDetailActivity::class.java)
                intent.putExtra("newItem", newItem)
                conCard.startActivity(intent)

            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SiteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_card_site, parent, false)
        return  SiteViewHolder(view)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: SiteViewHolder, position: Int) {
       val item = itemList[position]
        holder.bindView(item)

    }
}