package com.uninter.android_trabalho.filmeandroid.presentation.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.uninter.android_trabalho.R
import com.uninter.android_trabalho.filmeandroid.data.repository.FilmeAPIRepository

import com.uninter.android_trabalho.filmeandroid.domain.entities.Filme


class MainActivity : AppCompatActivity() {
    lateinit var  recycle : RecyclerView;
    private var filmes : List<Filme> = listOf();
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycle = findViewById(R.id.recycler_view)

       Thread(Runnable {
           FilmeAPIRepository.get()?.let{
                filmes = it;
           }
           recycle.post {
               loadRecycleView()
           }
           }).start();
       }
    fun loadRecycleView(){

        recycle.layoutManager = LinearLayoutManager(this);
        recycle.adapter = FilmeAdapter(filmes);
    }

}

