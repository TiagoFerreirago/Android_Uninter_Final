package com.uninter.android_trabalho

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.uninter.android_trabalho.entities.entitie
import com.uninter.android_trabalho.view.SiteAdapter
import com.uninter.android_trabalho.view.SiteDetailActivity

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
