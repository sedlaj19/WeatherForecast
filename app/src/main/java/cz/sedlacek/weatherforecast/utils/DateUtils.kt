package cz.sedlacek.weatherforecast.utils

import java.util.*

/**
 * Converts given timestamp to a Calendar instance
 *
 * @param timestamp timestamp in milliseconds
 *
 * @return Converted instance of Calendar
 */
fun convertDate(timestamp: Long): Calendar {
    val calendar: Calendar = Calendar.getInstance()
    calendar.timeInMillis = timestamp
    return calendar
}