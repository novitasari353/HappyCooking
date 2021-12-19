package com.novitasari.happycooking.models.search

data class Result(
    val id: Int,
    val image: String,
    val imageType: String,
    val nutrition: Nutrition,
    val title: String
)