package cz.sedlacek.weatherforecast.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Cloud (val all: Int): Parcelable