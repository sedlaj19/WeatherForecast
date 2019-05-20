package cz.sedlacek.weatherforecast.network

import cz.sedlacek.weatherforecast.API_KEY
import cz.sedlacek.weatherforecast.APP_ID_QUERY
import cz.sedlacek.weatherforecast.UNITS_METRIC
import cz.sedlacek.weatherforecast.UNITS_QUERY
import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

/**
 * Interceptor to add api key and units to every call
 */
class WeatherInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val original: Request = chain.request()
        val builder: HttpUrl.Builder = original.url().newBuilder()
        val url : HttpUrl = builder
            .addQueryParameter(APP_ID_QUERY, API_KEY)
            .addQueryParameter(UNITS_QUERY, UNITS_METRIC)
            .build()
        val request = original.newBuilder().url(url).build()
        return chain.proceed(request)
    }

}