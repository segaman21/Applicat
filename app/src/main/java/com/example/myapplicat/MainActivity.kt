package com.example.myapplicat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplicat.R
import com.example.myapplicat.ui.cats_list.CatsListFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}