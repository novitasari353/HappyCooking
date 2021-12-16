package com.nilatilmoena.happycooking.models.ingredients


import com.google.gson.annotations.SerializedName

data class Amount(
    val metric: Metric,
    val us: Us
)