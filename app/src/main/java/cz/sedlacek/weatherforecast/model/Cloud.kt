package cz.sedlacek.weatherforecast.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Cloud (val all: Int): Parcelable