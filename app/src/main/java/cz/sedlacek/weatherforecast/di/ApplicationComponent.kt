package cz.sedlacek.weatherforecast.di

import android.content.Context
import cz.sedlacek.weatherforecast.ui.detail.DetailViewModel
import cz.sedlacek.weatherforecast.ui.list.MainViewModel
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

/**
 * Dagger component allowing us to inject into our ViewModels
 */
@Singleton
@Component(modules = [NetworkModule::class])
interface ApplicationComponent {

    fun mainViewModelFactory(): ViewModelFactory<MainViewModel>
    fun detailViewModelFactory(): ViewModelFactory<DetailViewModel>

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun applicationContext(applicationContext: Context): Builder

        fun build(): ApplicationComponent
    }
}