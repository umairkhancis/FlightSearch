package com.noorifytech.flights.ui.factory

import com.noorifytech.flights.data.factory.FlightsRepositoryFactory
import com.noorifytech.flights.ui.presenter.FlightSearchPresenter
import com.noorifytech.flights.ui.presenter.impl.FlightSearchPresenterImpl
import com.noorifytech.flights.ui.usecase.FlightsSearchUseCaseImpl


object FlightSearchAppFactory {

    fun createFlightSearchPresenter(): FlightSearchPresenter {
        val getFlightSearchUseCase =
            FlightsSearchUseCaseImpl(FlightsRepositoryFactory.getFlightsRepository())

        return FlightSearchPresenterImpl(getFlightSearchUseCase)
    }
}