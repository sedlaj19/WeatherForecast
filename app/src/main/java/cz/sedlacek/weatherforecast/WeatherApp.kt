package cz.sedlacek.weatherforecast

import android.app.Application
import cz.sedlacek.weatherforecast.di.ApplicationComponent
import cz.sedlacek.weatherforecast.di.DaggerApplicationComponent
import cz.sedlacek.weatherforecast.di.DaggerComponentProvider

/**
 * This class is used in manifest to override default Application. I use this to make dependency injection working.
 */
class WeatherApp: Application(), DaggerComponentProvider {
    override val component: ApplicationComponent by lazy {
        DaggerApplicationComponent.builder()
            .applicationContext(applicationContext)
            .build()
    }

}