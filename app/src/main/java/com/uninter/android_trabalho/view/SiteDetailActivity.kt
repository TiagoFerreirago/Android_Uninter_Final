package com.uninter.android_trabalho.view

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.uninter.android_trabalho.R
import com.uninter.android_trabalho.entities.entitie

class SiteDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_site_detail)

        val item = intent.getSerializableExtra("newItem") as entitie

        findViewById<TextView>(R.id.detail_titulo).text = item.title
        findViewById<TextView>(R.id.detail_subtitulo).text = item.subtitulo
        }
    }
