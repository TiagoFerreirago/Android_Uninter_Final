package com.uninter.android_trabalho.filmeandroid.presentation.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.uninter.android_trabalho.R
import com.uninter.android_trabalho.filmeandroid.data.repository.FilmeAPIRepository
import com.uninter.android_trabalho.filmeandroid.presentation.viewmodel.FilmeViewModelFactory


import com.uninter.android_trabalho.filmeandroid.presentation.viewmodel.MainViewModel


class MainActivity : AppCompatActivity() {
    lateinit var  recycle : RecyclerView
   val viewModel by lazy{
        var factory = FilmeViewModelFactory(application)
        ViewModelProvider(this, factory)[MainViewModel::class.java]
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycle = findViewById(R.id.recycler_view)

        viewModel.listFilme.observe(this){
            recycle.layoutManager = LinearLayoutManager(this);
            recycle.adapter = FilmeAdapter(it);
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.load()
    }
}

