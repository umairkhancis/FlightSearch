package com.noorifytech.flights.data.dao.backend.impl

import com.noorifytech.flights.common.AppException
import com.noorifytech.flights.common.ErrorCodes
import com.noorifytech.flights.data.dao.backend.FlightsBackendDao
import com.noorifytech.flights.data.dao.backend.dto.ApiErrorResponse
import com.noorifytech.flights.data.dao.backend.dto.ApiResponse
import com.noorifytech.flights.data.dao.backend.dto.ApiSuccessResponse
import com.noorifytech.flights.data.dao.backend.dto.FlightsResponse
import com.noorifytech.flights.data.dao.backend.impl.retrofit.FlightsApi
import io.reactivex.Observable

class FlightsBackendDaoImpl(private val api: FlightsApi) : FlightsBackendDao {

    override fun getFlights(): Observable<FlightsResponse> {
        return api.getFlights()
            .map { ApiResponse.create(it) }
            .flatMap { apiResponse: ApiResponse<FlightsResponse> ->
                when (apiResponse) {
                    is ApiSuccessResponse -> Observable.just(apiResponse.body)
                    is ApiErrorResponse -> Observable.error(
                        AppException(
                            ErrorCodes.BACKEND_ERROR,
                            apiResponse.errorMessage
                        )
                    )
                    else -> Observable.error(
                        AppException(
                            ErrorCodes.GENERIC_ERROR,
                            "generic error"
                        )
                    )
                }
            }
    }
}