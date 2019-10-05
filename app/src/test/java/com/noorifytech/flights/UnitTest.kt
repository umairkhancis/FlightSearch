package com.noorifytech.flights

import com.noorifytech.flights.common.FlightMapper
import org.junit.Assert
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class UnitTest {
    @Test
    fun timeFormat() {
        // Arrange
        val flightMapper = FlightMapper
        val dateFormat = "2020-11-01T10:55"

        // Act
        val arrivalDeptFormat = flightMapper.getTime(dateFormat)

        // Assert
        Assert.assertEquals("10:55", arrivalDeptFormat)
    }

    @Test
    fun durationHourMinsFormat() {
        // Arrange
        val flightMapper = FlightMapper
        val duration = 190

        // Act
        val hourMinsFormat = flightMapper.getHourMinsFormat(duration)

        // Assert
        Assert.assertEquals("3h 10m", hourMinsFormat)
    }
}
