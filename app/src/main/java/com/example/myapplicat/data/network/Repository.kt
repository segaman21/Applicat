package com.example.myapplicat.data.network

import android.content.Context
import com.example.myapplicat.data.model.ModelCategories
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class Repository {
    private val api = NetworkModule().provideApi()
//    private val key = "533ac9a5-6204-4c64-8faa-3e6494c6a961"

    suspend fun loadAllCats(context: Context): List<ModelCategories>? {
        var cat: List<ModelCategories>? = null
        cat = withContext(Dispatchers.IO){
            api.loadAllCats()}
        return cat
    }
    suspend fun getChosenCat(context: Context, catId: String?): ModelCategories? {
        var cat: ModelCategories? = null
        cat = withContext(Dispatchers.IO){
            api.getChosenCat(catId)}
        return cat
    }
}