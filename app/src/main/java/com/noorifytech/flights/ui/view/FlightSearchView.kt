package com.noorifytech.flights.ui.view

import com.noorifytech.flights.data.repository.vo.FlightVO
import com.noorifytech.flights.ui.base.BaseLoadableContentView

interface FlightSearchView : BaseLoadableContentView {
    fun showFlightsSearchResults(flightsSearchResults: List<FlightVO>)
}