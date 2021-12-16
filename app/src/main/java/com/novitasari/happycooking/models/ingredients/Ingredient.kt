package com.nilatilmoena.happycooking.models.ingredients


import com.google.gson.annotations.SerializedName

data class Ingredient(
    val amount: Amount,
    val image: String,
    val name: String
)