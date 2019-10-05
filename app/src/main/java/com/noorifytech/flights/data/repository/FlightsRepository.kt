package com.noorifytech.flights.data.repository

import com.noorifytech.flights.data.repository.vo.FlightVO
import io.reactivex.Observable

interface FlightsRepository {
    fun getFlights(): Observable<List<FlightVO>>
}