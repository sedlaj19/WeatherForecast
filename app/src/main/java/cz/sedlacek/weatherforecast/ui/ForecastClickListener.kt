package cz.sedlacek.weatherforecast.ui

import androidx.databinding.ViewDataBinding

/**
 * Listener to pass binding when user clicks on a city item
 */
interface ForecastClickListener<T : ViewDataBinding> {

    fun onClick(binding: T)
}