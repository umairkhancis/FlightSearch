package com.noorifytech.flights.data.repository.vo

data class LegVO(
    val id: String,
    val departureAirport: String,
    val arrivalAirport: String,
    val departureTime: String,
    val arrivalTime: String,
    val stops: Int,
    val airlineName: String,
    val airlineId: String,
    val durationInMins: String
){
    fun getAirlineImageUrl(): String =
        "https://logos.skyscnr.com/images/airlines/small/$airlineId.png"
}