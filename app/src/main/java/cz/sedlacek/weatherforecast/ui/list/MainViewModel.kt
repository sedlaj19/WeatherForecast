package cz.sedlacek.weatherforecast.ui.list

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import cz.sedlacek.weatherforecast.BaseViewModel
import cz.sedlacek.weatherforecast.CITIES_ID
import cz.sedlacek.weatherforecast.model.ForecastGroup
import cz.sedlacek.weatherforecast.network.WeatherApi
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * ViewModel class for Main screen. It fetches current forecasts for the list of cities.
 */
class MainViewModel @Inject constructor(private val weatherApi: WeatherApi) : BaseViewModel() {

    private val forecast = MutableLiveData<ForecastGroup>()

    fun forecast(): LiveData<ForecastGroup> = forecast

    init {
        loadCitiesForecast()
    }

    private fun loadCitiesForecast() {
        loadingVisibility.value = View.VISIBLE
        viewModelScope.launch(handler) {
            val response = weatherApi.getCitiesForecastAsync(CITIES_ID).await()
            forecast.value = response
            loadingVisibility.value = View.GONE
        }
    }
}