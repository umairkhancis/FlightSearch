package com.noorifytech.flights.ui.view.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.noorifytech.flights.R
import com.noorifytech.flights.data.repository.vo.FlightVO
import com.noorifytech.flights.ui.factory.FlightSearchAppFactory
import com.noorifytech.flights.ui.presenter.FlightSearchPresenter
import com.noorifytech.flights.ui.view.FlightSearchView
import com.noorifytech.flights.ui.view.adapter.FlightsAdapter
import kotlinx.android.synthetic.main.activity_flight_search_results_list.*

class FlightSearchActivity : AppCompatActivity(), FlightSearchView {

    private lateinit var flightsAdapter: FlightsAdapter
    private lateinit var presenter: FlightSearchPresenter

//    =======================  Android Activity Callback Methods =======================

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_flight_search_results_list)

        init()
    }

    override fun onDestroy() {
        super.onDestroy()

        presenter.onDetach()
    }

//    =======================  FlightSearchView Implementation =======================

    override fun showFlightsSearchResults(flightsSearchResults: List<FlightVO>) {
        flightSearchResultsListRV.layoutManager = LinearLayoutManager(this)
//        flightSearchResultsListRV.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))

        flightsAdapter = FlightsAdapter(this, flightsSearchResults)
        flightSearchResultsListRV.adapter = flightsAdapter
    }

    override fun showLoading() {
        progressBar.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        progressBar.visibility = View.GONE
    }

    override fun showNoContent() {
        Snackbar.make(
            flightSearchResultsListRoot,
            R.string.error_no_content_message,
            Snackbar.LENGTH_LONG
        ).show()
    }

    override fun showNoConnection() {
        Snackbar.make(
            flightSearchResultsListRoot,
            R.string.no_internet,
            Snackbar.LENGTH_LONG
        ).show()
    }

    override fun showError() {
        Snackbar.make(
            flightSearchResultsListRoot,
            R.string.error_generic_message,
            Snackbar.LENGTH_LONG
        ).show()
    }

//    ==============================  Private Methods ==============================

    private fun init() {
        // Prepare presenter to take up the control
        presenter = FlightSearchAppFactory.createFlightSearchPresenter()
        presenter.initView(this)
        presenter.onAttach()
    }
}