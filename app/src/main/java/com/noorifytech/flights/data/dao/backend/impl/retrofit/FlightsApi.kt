package com.noorifytech.flights.data.dao.backend.impl.retrofit

import com.noorifytech.flights.data.dao.backend.dto.FlightsResponse
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.GET

interface FlightsApi {
    @GET("skyscanner-prod-takehome-test/flights.json")
    fun getFlights(): Observable<Response<FlightsResponse>>
}