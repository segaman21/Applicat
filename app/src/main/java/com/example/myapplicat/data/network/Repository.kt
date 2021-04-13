package com.example.myapplicat.data.network

import android.content.Context
import com.example.myapplicat.data.model.ModelCategories
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class Repository {
    private val api = NetworkModule().provideApi()
    private val key = "533ac9a5-6204-4c64-8faa-3e6494c6a961"

    suspend fun loadCats(context: Context): List<ModelCategories>? {
        var cat: List<ModelCategories>? = null
        cat = withContext(Dispatchers.IO){
            api.loadCats()}
        return cat
    }
    suspend fun getCats(context: Context, catId: String?): List<ModelCategories>? {
        var cat: List<ModelCategories>? = null
        cat = withContext(Dispatchers.IO){
            api.loadCats()}
        return cat
    }
}