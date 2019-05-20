package cz.sedlacek.weatherforecast.di

import android.app.Activity

/**
 * Allows us to easily inject things in an Activity through injector.inject(). The Activity does not know
 * anything about the its injector.
 */
interface DaggerComponentProvider {
    val component: ApplicationComponent
}

val Activity.injector get() = (application as DaggerComponentProvider).component