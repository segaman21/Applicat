package com.example.myapplicat.data.network

import com.example.myapplicat.data.model.ModelCategories
import retrofit2.http.GET
import retrofit2.http.Path


interface CatsApi {
    @GET("breeds")
    suspend fun loadAllCats(): List<ModelCategories>

    @GET("breeds/{cat_id}")
    suspend fun getChosenCat(
        @Path("cat_id") catId: String?,
    ): ModelCategories
}