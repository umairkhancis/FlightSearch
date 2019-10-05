package com.noorifytech.flights.data.factory

import com.noorifytech.flights.common.FlightMapper
import com.noorifytech.flights.data.dao.backend.impl.FlightsBackendDaoImpl
import com.noorifytech.flights.data.dao.backend.impl.retrofit.FlightsApi
import com.noorifytech.flights.data.dao.backend.impl.retrofit.RetrofitFactory
import com.noorifytech.flights.data.repository.FlightsRepository
import com.noorifytech.flights.data.repository.impl.FlightsRepositoryImpl


object FlightsRepositoryFactory {

    fun getFlightsRepository(): FlightsRepository {
        val backendFlightsApi = RetrofitFactory.getDefaultRetrofit()
            .create(FlightsApi::class.java)

        val flightsBackendDao = FlightsBackendDaoImpl(backendFlightsApi)

        return FlightsRepositoryImpl(flightsBackendDao, FlightMapper)
    }
}