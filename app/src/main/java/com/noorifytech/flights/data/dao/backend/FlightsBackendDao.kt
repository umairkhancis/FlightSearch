package com.noorifytech.flights.data.dao.backend

import com.noorifytech.flights.data.dao.backend.dto.FlightsResponse
import io.reactivex.Observable

interface FlightsBackendDao {
    fun getFlights(): Observable<FlightsResponse>
}