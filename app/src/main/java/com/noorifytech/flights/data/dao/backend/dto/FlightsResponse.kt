package com.noorifytech.flights.data.dao.backend.dto

import com.google.gson.annotations.SerializedName

data class FlightsResponse(

    @SerializedName("itineraries")
    val itineraries: List<Itinerary>,

    @SerializedName("legs")
    val legs: List<Leg>
)