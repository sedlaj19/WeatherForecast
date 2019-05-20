package cz.sedlacek.weatherforecast.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Coordinates(val lon: Float, val lat: Float): Parcelable