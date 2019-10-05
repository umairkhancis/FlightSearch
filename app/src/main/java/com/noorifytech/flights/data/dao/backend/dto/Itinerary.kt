package com.noorifytech.flights.data.dao.backend.dto

import com.google.gson.annotations.SerializedName

data class Itinerary(
    @SerializedName("id")
    val id: String,

    @SerializedName("legs")
    val legs: List<String>,

    @SerializedName("price")
    val price: String,

    @SerializedName("agent")
    val agent: String,

    @SerializedName("agent_rating")
    val agent_rating: Float
)