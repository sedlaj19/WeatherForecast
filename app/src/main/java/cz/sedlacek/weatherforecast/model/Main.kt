package cz.sedlacek.weatherforecast.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Main(val temp: Float, val pressure: Float, val humidity: Int, val temp_min: Float, val temp_max: Float): Parcelable