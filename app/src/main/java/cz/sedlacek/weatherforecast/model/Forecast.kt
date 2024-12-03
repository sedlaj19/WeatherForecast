package cz.sedlacek.weatherforecast.model

import android.os.Parcelable
import cz.sedlacek.weatherforecast.*
import cz.sedlacek.weatherforecast.utils.convertDate
import kotlinx.parcelize.Parcelize
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.round

@Parcelize
data class Forecast(
	val id: Long,
	val name: String,
	val coord: Coordinates,
	val sys: Sys,
	val weather: List<Weather>,
	val main: Main,
	val wind: Wind,
	val clouds: Cloud,
	val dt: Long,
	val visibility: Int
) : Parcelable {

	/**
	 * Returns weather description, if the weather list is empty, it returns empty String
	 */
	fun weatherDescription(): String {
		if (weather.isEmpty()) {
			return ""
		}
		return weather[0].description
	}

	/**
	 * Returns the day of the week from a dt attribute
	 */
	fun dayAsText(): Int {
		val cal = convertDate(dt * 1000)
		val now = Calendar.getInstance()
		if (cal.get(Calendar.DAY_OF_YEAR) == now.get(Calendar.DAY_OF_YEAR)) {
			return R.string.today
		}
		return when (cal.get(Calendar.DAY_OF_WEEK)) {
			Calendar.MONDAY -> R.string.monday
			Calendar.TUESDAY -> R.string.tuesday
			Calendar.WEDNESDAY -> R.string.wednesday
			Calendar.THURSDAY -> R.string.thursday
			Calendar.FRIDAY -> R.string.friday
			Calendar.SATURDAY -> R.string.saturday
			else -> R.string.sunday
		}
	}

	/**
	 * Converts dt attribute to a time in HH:mm format
	 */
	fun time(): String {
		val sdt = SimpleDateFormat.getTimeInstance(DateFormat.SHORT)
		sdt.timeZone = TimeZone.getDefault()
		return sdt.format(Date(dt * 1000))
	}

	/**
	 * Returns given value as String with appropriate unit (°C)
	 *
	 * @param value value to be converted to String
	 */
	fun valueDegrees(value: Float): String {
		return "${safeValue(value)}$UNIT_CELSIUS"
	}

	/**
	 * Returns wind value as String with appropriate unit (m/s)
	 */
	fun valueWind(): String {
		return "${safeValue(wind.speed)} $UNIT_METER_PER_SEC"
	}

	/**
	 * Returns pressure value as String with appropriate unit (hPa)
	 */
	fun valuePressure(): String {
		return "${safeValue(main.pressure)} $UNIT_H_PA"
	}

	/**
	 * Returns humidity value as String with appropriate unit (%)
	 */
	fun valueHumidity(): String {
		return "${safeValue(main.humidity)}$UNIT_PERCENT"
	}

	/**
	 * Returns visibility value as String with appropriate unit (km)
	 */
	fun valueVisibility(): String {
		return "${safeValue(visibility / 1000)} $UNIT_KM"
	}

	/**
	 * Converts values to String, because of data binding
	 */
	private fun safeValue(value: Any): String {
		if (value is Float) {
			return round(value).toInt().toString()
		}
		return value.toString()
	}
}