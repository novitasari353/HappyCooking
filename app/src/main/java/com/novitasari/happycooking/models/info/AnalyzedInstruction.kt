package com.novitasari.happycooking.models.info

data class AnalyzedInstruction(
    val name: String,
    val steps: List<Step>
)