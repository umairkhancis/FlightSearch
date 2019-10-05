package com.noorifytech.flights.data.repository.vo

data class ItineraryVO(
    val id: String,
    val legs: List<String>,
    val price: String,
    val agent: String,
    val agent_rating: Float
)