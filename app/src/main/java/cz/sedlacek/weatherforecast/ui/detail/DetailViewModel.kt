package cz.sedlacek.weatherforecast.ui.detail

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import cz.sedlacek.weatherforecast.BaseViewModel
import cz.sedlacek.weatherforecast.model.DailyForecastResponse
import cz.sedlacek.weatherforecast.network.WeatherApi
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * ViewModel class for Detail screen. It fetches forecasts for the next three days.
 */
class DetailViewModel @Inject constructor(private val weatherApi: WeatherApi) : BaseViewModel() {

    private val forecast = MutableLiveData<DailyForecastResponse>()

    fun forecast(): LiveData<DailyForecastResponse> = forecast

    fun loadDailyForecast(cityId: Long) {
        loadingVisibility.value = View.VISIBLE
        viewModelScope.launch(handler) {
            val response = weatherApi.getDailyForecastAsync(cityId).await()
            forecast.value = response
            loadingVisibility.value = View.GONE
        }
    }
}