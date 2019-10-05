package com.noorifytech.flights.data.repository.impl

import com.noorifytech.flights.common.FlightMapper
import com.noorifytech.flights.data.dao.backend.FlightsBackendDao
import com.noorifytech.flights.data.repository.FlightsRepository
import com.noorifytech.flights.data.repository.vo.FlightVO
import io.reactivex.Observable

class FlightsRepositoryImpl(
    private val flightsBackendDao: FlightsBackendDao,
    private val flightMapper: FlightMapper
) : FlightsRepository {

    override fun getFlights(): Observable<List<FlightVO>> {
        return flightsBackendDao.getFlights()
            .flatMap { Observable.just(flightMapper.toFlightsVO(it)) }
    }
}