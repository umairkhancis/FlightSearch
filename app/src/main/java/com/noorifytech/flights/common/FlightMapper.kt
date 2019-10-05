package com.noorifytech.flights.common

import android.annotation.SuppressLint
import com.noorifytech.flights.data.dao.backend.dto.FlightsResponse
import com.noorifytech.flights.data.repository.vo.FlightVO
import com.noorifytech.flights.data.repository.vo.ItineraryVO
import com.noorifytech.flights.data.repository.vo.LegVO

object FlightMapper {
    fun toFlightsVO(flightsResponse: FlightsResponse): List<FlightVO> {
        val flights = mutableListOf<FlightVO>()

        flightsResponse.itineraries.forEach { itinerary ->
            val itineraryVO = ItineraryVO(
                itinerary.id,
                itinerary.legs,
                itinerary.price,
                itinerary.agent,
                itinerary.agent_rating
            )

            val legsVO = flightsResponse.legs
                .filter { itinerary.legs.contains(it.id) }
                .map {
                    LegVO(
                        it.id,
                        it.departureAirport,
                        it.arrivalAirport,
                        getTime(it.departureTime),
                        getTime(it.arrivalTime),
                        it.stops,
                        it.airlineName,
                        it.airlineId,
                        getHourMinsFormat(it.durationInMins)
                    )
                }

            flights.add(FlightVO(itineraryVO, legsVO))
        }

        return flights
    }

    @SuppressLint("SimpleDateFormat")
    fun getTime(str: String): String {
        val time = str.split("T")
        return time[1]
    }

    fun getHourMinsFormat(duration: Int): String {
        val hours = duration / 60
        val mins = duration % 60

        return when {
            hours < 1 -> "${mins}m"
            mins < 1 -> "${hours}h"
            else -> "${hours}h ${mins}m"
        }

    }


}