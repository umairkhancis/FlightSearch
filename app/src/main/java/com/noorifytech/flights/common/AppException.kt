package com.noorifytech.flights.common

data class AppException(val code: Int, val msg: String) : Exception(msg)