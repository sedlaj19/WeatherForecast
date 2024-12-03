package cz.sedlacek.weatherforecast.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Sys (val type: Int, val id: Long, val country: String, val sunrise: Long, val sunset: Long): Parcelable