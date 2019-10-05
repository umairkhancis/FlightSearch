package com.noorifytech.flights.ui.presenter.impl

import com.noorifytech.flights.data.repository.vo.FlightVO
import com.noorifytech.flights.ui.base.BasePresenterImpl
import com.noorifytech.flights.ui.presenter.FlightSearchPresenter
import com.noorifytech.flights.ui.usecase.FlightsSearchUseCase
import com.noorifytech.flights.ui.view.FlightSearchView
import io.reactivex.observers.DisposableObserver
import timber.log.Timber

class FlightSearchPresenterImpl(private val flightsSearchUseCase: FlightsSearchUseCase) :
    BasePresenterImpl<FlightSearchView>(), FlightSearchPresenter {

    override fun onAttach() {

        view.showLoading()
        val callback = object : DisposableObserver<List<FlightVO>>() {
            override fun onNext(list: List<FlightVO>) {
                view.hideLoading()
                view.showFlightsSearchResults(list)
            }

            override fun onError(e: Throwable) {
                Timber.e("onError: ${e.message}")

                view.hideLoading()
                view.showError()
            }

            override fun onComplete() {
                Timber.i("onComplete")
            }

        }

        this.baseProcessor.process(
            business = flightsSearchUseCase.getFlights(),
            callback = callback
        )
    }
}
