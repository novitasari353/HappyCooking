package com.novitasari.happycooking.api

import com.novitasari.happycooking.models.search.search
import retrofit2.Call
import retrofit2.http.GET

interface searchApi {
    @GET("recipes/complexSearch?apiKey=17b8626c98094d8c9165488c754e525f&number=20")
    fun getResponse(): Call<search>

}