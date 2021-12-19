package com.novitasari.happycooking.api

import com.nilatilmoena.happycooking.models.ingredients.bahan
import retrofit2.Call
import retrofit2.http.GET

interface ingredientsApi2 {
    @GET("recipes/652608/ingredientWidget.json?apiKey=838a88818de54ad19a5935768d2ae9a7")
    fun getResponse(): Call<bahan>
}