package cz.sedlacek.weatherforecast.ui.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import cz.sedlacek.weatherforecast.R
import cz.sedlacek.weatherforecast.databinding.ItemCityBinding
import cz.sedlacek.weatherforecast.model.Forecast
import cz.sedlacek.weatherforecast.ui.ForecastClickListener

/**
 * Adapter to display list of cities
 */
class CitiesAdapter(private val listener: ForecastClickListener<ItemCityBinding>) : RecyclerView.Adapter<CitiesAdapter.ViewHolder>() {

    private lateinit var citiesList: List<Forecast>

    override fun getItemCount(): Int {
        return if (::citiesList.isInitialized) citiesList.size else 0
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(citiesList[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = DataBindingUtil.inflate<ItemCityBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_city,
            parent,
            false
        )
        return ViewHolder(binding)
    }

    fun updateCities(citiesList: List<Forecast>) {
        this.citiesList = citiesList
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val binding: ItemCityBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(forecast: Forecast) {
            binding.forecast = forecast
            binding.root.setOnClickListener {
                listener.onClick(binding)
            }
        }
    }
}