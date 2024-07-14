package com.uninter.android_trabalho.filmeandroid.presentation.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.uninter.android_trabalho.R
import com.uninter.android_trabalho.filmeandroid.domain.entities.entitie

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recycle : RecyclerView = findViewById(R.id.recycler_view)

        val itemList = listOf(
            entitie("Item 1", "Subtitle 1"),
            entitie("Item 2", "Subtitle 2"),
            entitie("Item 3", "Subtitle 3")
        )

        recycle.layoutManager = LinearLayoutManager(this)
        recycle.adapter = SiteAdapter(itemList)
        }
    }
