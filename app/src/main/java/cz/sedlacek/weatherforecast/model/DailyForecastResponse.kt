package cz.sedlacek.weatherforecast.model

import cz.sedlacek.weatherforecast.utils.convertDate
import java.util.*

data class DailyForecastResponse(val cnt: Int, val list: List<Forecast>, val city: City) {

    /**
     * Returns list of forecasts for current date
     */
    fun today(): List<Forecast> {
        val date: Calendar = Calendar.getInstance()
        return forecastsForDay(date)
    }

    /**
     * Returns list of forecasts for current date + 1
     */
    fun firstDay(): List<Forecast> {
        val date: Calendar = Calendar.getInstance()
        date.add(Calendar.DAY_OF_YEAR, 1)
        return forecastsForDay(date)
    }

    /**
     * Returns list of forecasts for current date + 2
     */
    fun secondDay(): List<Forecast> {
        val date: Calendar = Calendar.getInstance()
        date.add(Calendar.DAY_OF_YEAR, 2)
        return forecastsForDay(date)
    }

    /**
     * Returns list of forecasts for current date + 3
     */
    fun thirdDay(): List<Forecast> {
        val date: Calendar = Calendar.getInstance()
        date.add(Calendar.DAY_OF_YEAR, 3)
        return forecastsForDay(date)
    }

    /**
     * Filters forecasts for given date
     *
     * @param date day specified by this date will be used to filter forecasts
     *
     * @return list of filtered forecasts for given date
     */
    private fun forecastsForDay(date: Calendar): List<Forecast> {
        return list.filter { forecast -> convertDate(forecast.dt * 1000).get(Calendar.DAY_OF_YEAR) == date.get(Calendar.DAY_OF_YEAR) }
    }
}