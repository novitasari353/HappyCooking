package com.novitasari.happycooking.api

import com.novitasari.happycooking.models.info.info
import retrofit2.Call
import retrofit2.http.GET

interface informationApi2 {
    @GET("recipes/652608/information?apiKey=838a88818de54ad19a5935768d2ae9a7&includeNutrition=false")
    fun getResponse(): Call<info>
}