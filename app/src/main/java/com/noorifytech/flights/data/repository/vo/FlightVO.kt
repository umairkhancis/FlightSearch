package com.noorifytech.flights.data.repository.vo

data class FlightVO(
    val itinerary: ItineraryVO,
    val legs: List<LegVO>
)