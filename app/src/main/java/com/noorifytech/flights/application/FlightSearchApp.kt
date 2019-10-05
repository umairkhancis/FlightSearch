package com.noorifytech.flights.application

import android.app.Application
import com.noorifytech.flights.BuildConfig
import timber.log.Timber

class FlightSearchApp : Application() {
    override fun onCreate() {
        super.onCreate()

        instance = this

        if(BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    companion object {
        var instance: Application? = null
    }
}