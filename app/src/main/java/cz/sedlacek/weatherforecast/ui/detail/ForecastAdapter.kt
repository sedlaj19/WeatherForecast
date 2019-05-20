package cz.sedlacek.weatherforecast.ui.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import cz.sedlacek.weatherforecast.R
import cz.sedlacek.weatherforecast.databinding.ItemWeatherSmallBinding
import cz.sedlacek.weatherforecast.model.Forecast

/**
 * Adapter to display list of forecasts
 */
class ForecastAdapter : RecyclerView.Adapter<ForecastAdapter.ViewHolder>() {

    private lateinit var forecastList: List<Forecast>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = DataBindingUtil.inflate<ItemWeatherSmallBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_weather_small,
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return if (::forecastList.isInitialized) forecastList.size else 0
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(forecastList[position])
    }

    fun updateForecasts(forecastList: List<Forecast>) {
        this.forecastList = forecastList
        notifyDataSetChanged()
    }


    inner class ViewHolder(private val binding: ItemWeatherSmallBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(forecast: Forecast) {
            binding.temp = forecast.valueDegrees(forecast.main.temp)
            binding.desc = forecast.weather[0].description
            binding.time = forecast.time()
        }
    }
}