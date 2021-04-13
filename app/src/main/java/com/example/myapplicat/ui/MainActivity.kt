package com.example.myapplicat.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplicat.R
import com.example.myapplicat.ui.cats_list.CatsList

class MainActivity : AppCompatActivity() {
    private val first = CatsList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.fragments_container, first)
                .commit()
        }
    }
}