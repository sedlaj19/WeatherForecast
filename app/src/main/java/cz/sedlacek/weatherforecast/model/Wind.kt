package cz.sedlacek.weatherforecast.model

import android.os.Parcelable
import cz.sedlacek.weatherforecast.R
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Wind (val speed: Float, val deg: Float): Parcelable {

    fun description(): Int {
        if (deg <= 22F || deg >= 338F) { // From North
            return R.string.wind_from_north
        }
        if (deg < 68F && deg > 22F) { // From NorthEast
            return R.string.wind_from_north_east
        }
        if (deg in 68F..112F) { // From East
            return R.string.wind_from_east
        }
        if (deg < 158F && deg > 112F) { // From SouthEast
            return R.string.wind_from_south_east
        }
        if (deg in 158F..202F) { // From South
            return R.string.wind_from_south
        }
        if (deg < 248F && deg > 202F) { // From SouthWest
            return R.string.wind_from_south_west
        }
        if (deg in 248F..292F) { // From West
            return R.string.wind_from_west
        }
        return R.string.wind_from_north_west
    }

}