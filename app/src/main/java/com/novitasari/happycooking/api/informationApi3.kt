package com.novitasari.happycooking.api

import com.novitasari.happycooking.models.info.info
import retrofit2.Call
import retrofit2.http.GET

interface informationApi3 {
    @GET("recipes/638420/information?apiKey=17b8626c98094d8c9165488c754e525f&includeNutrition=false")
    fun getResponse(): Call<info>
}