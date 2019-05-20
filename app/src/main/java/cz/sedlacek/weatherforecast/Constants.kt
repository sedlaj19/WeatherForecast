package cz.sedlacek.weatherforecast

/**
 * Contains static constants to easily change some configuration
 */

const val API_VERSION = "data/2.5/"
//const val CURRENT_FORECAST_ENDPOINT = API_VERSION + "weather"
const val CURRENT_GROUP_FORECAST_ENDPOINT = API_VERSION + "group"
const val FIVE_DAYS_FORECAST_ENDPOINT = API_VERSION + "forecast"
const val ICON_ENDPOINT = "img/w/"

const val API_KEY = "b90ee1c07c911029fecf4838c4dd6272"
const val APP_ID_QUERY = "APPID"
const val UNITS_QUERY = "units"
const val UNITS_METRIC = "metric"
const val CITIES_ID = "3067696,2761369,3061369,2643743,2988507,2179537,5128581,2950159,3128760,1850147"

const val ARG_FORECAST = "forecast_object"
const val ARG_CITY_ID = "city_id"
const val ARG_CITY_NAME = "city_name"

const val UNIT_CELSIUS = "°C"
const val UNIT_PERCENT = "%"
const val UNIT_H_PA = "hPa"
const val UNIT_METER_PER_SEC = "m/s"
const val UNIT_KM = "km"