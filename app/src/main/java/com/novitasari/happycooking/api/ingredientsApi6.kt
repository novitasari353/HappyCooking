package com.novitasari.happycooking.api

import com.nilatilmoena.happycooking.models.ingredients.bahan
import retrofit2.Call
import retrofit2.http.GET

interface ingredientsApi6 {
    @GET("recipes/662264/ingredientWidget.json?apiKey=17b8626c98094d8c9165488c754e525f")
    fun getResponse(): Call<bahan>

}