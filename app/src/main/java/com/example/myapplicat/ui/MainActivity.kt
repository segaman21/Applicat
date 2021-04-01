package com.example.myapplicat.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplicat.R

class MainActivity : AppCompatActivity() {
    private val first = FirstFragment()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .add(R.id.fragments_container,first)
            .commit()
    }

}