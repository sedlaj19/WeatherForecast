package cz.sedlacek.weatherforecast.network

import cz.sedlacek.weatherforecast.CURRENT_GROUP_FORECAST_ENDPOINT
import cz.sedlacek.weatherforecast.FIVE_DAYS_FORECAST_ENDPOINT
import cz.sedlacek.weatherforecast.model.DailyForecastResponse
import cz.sedlacek.weatherforecast.model.ForecastGroup
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Interface with backend request methods
 */
interface WeatherApi {

    @GET(CURRENT_GROUP_FORECAST_ENDPOINT)
    fun getCitiesForecastAsync(@Query("id") id: String): Deferred<ForecastGroup>

    @GET(FIVE_DAYS_FORECAST_ENDPOINT)
    fun getDailyForecastAsync(@Query("id") id: Long): Deferred<DailyForecastResponse>

}