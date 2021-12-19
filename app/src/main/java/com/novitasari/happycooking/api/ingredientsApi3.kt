package com.novitasari.happycooking.api

import retrofit2.Call
import retrofit2.http.GET
import com.nilatilmoena.happycooking.models.ingredients.bahan

interface ingredientsApi3 {
    @GET("recipes/660820/ingredientWidget.json?apiKey=17b8626c98094d8c9165488c754e525f")
    fun getResponse(): Call<bahan>
}