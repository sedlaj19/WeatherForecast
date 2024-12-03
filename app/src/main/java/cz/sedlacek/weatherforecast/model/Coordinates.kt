package cz.sedlacek.weatherforecast.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Coordinates(val lon: Float, val lat: Float): Parcelable