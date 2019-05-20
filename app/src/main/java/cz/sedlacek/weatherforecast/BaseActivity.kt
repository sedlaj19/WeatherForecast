package cz.sedlacek.weatherforecast

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer

/**
 * Base Activity which should be extended by all used activities in the project. It helps to handle errors and display
 * message to the user. This could be improved to show more sophisticated dialogs or messages ...
 */
abstract class BaseActivity<T : BaseViewModel> : AppCompatActivity() {

    protected lateinit var viewModel : T

    protected abstract fun initViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewModel()
        viewModel.throwable().observe(this, Observer {throwable ->
            onError(throwable)
        })
    }

    /**
     * This method could be improved to show better messages. It could also be protected instead of private, so
     * it would be possible to override it for different purposes inside any activity.
     */
    private fun onError(throwable: Throwable) {
        Toast.makeText(this, throwable.message, Toast.LENGTH_SHORT).show()
    }
}