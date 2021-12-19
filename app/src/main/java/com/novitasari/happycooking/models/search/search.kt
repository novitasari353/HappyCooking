package com.novitasari.happycooking.models.search

data class search(
    val number: Int,
    val offset: Int,
    val results: List<Result>,
    val totalResults: Int
)