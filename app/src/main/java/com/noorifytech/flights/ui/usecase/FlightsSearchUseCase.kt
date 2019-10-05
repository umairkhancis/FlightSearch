package com.noorifytech.flights.ui.usecase

import com.noorifytech.flights.data.repository.FlightsRepository
import com.noorifytech.flights.data.repository.vo.FlightVO
import io.reactivex.Observable

interface FlightsSearchUseCase {
    fun getFlights(): Observable<List<FlightVO>>
}

class FlightsSearchUseCaseImpl(private val flightsRepository: FlightsRepository) :
    FlightsSearchUseCase {

    override fun getFlights(): Observable<List<FlightVO>> = flightsRepository.getFlights()
}