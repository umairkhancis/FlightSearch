package com.noorifytech.flights.data.dao.backend.dto

import com.google.gson.annotations.SerializedName

data class Leg(
    @SerializedName("id")
    val id: String,

    @SerializedName("departure_airport")
    val departureAirport: String,

    @SerializedName("arrival_airport")
    val arrivalAirport: String,

    @SerializedName("departure_time")
    val departureTime: String,

    @SerializedName("arrival_time")
    val arrivalTime: String,

    @SerializedName("stops")
    val stops: Int,

    @SerializedName("airline_name")
    val airlineName: String,

    @SerializedName("airline_id")
    val airlineId: String,

    @SerializedName("duration_mins")
    val durationInMins: Int
)