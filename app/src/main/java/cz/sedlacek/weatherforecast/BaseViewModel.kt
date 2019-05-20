package cz.sedlacek.weatherforecast

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineExceptionHandler

/**
 * Base ViewModel class which should be extended by any ViewModel. It provides basic error handling and progress
 * variable, which then can be used in any ViewModel
 */
abstract class BaseViewModel : ViewModel() {

    private val throwable : MutableLiveData<Throwable> = MutableLiveData()

    val loadingVisibility: MutableLiveData<Int> = MutableLiveData()

    protected val handler = CoroutineExceptionHandler { _, exception ->
        println("Caught $exception")
        throwable.value = exception
        loadingVisibility.value = View.GONE
    }

    fun throwable() = throwable

}