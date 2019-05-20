package cz.sedlacek.weatherforecast.binding

import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer

/**
 * Custom binding adapters to set values for different Views
 */
/**
 * Sets visibility based on LiveData from ViewModel
 */
@BindingAdapter("mutableVisibility")
fun setMutableVisibility(view: View, visibility: MutableLiveData<Int>?) {
    val parentActivity: AppCompatActivity? = view.getParentActivity()
    if (parentActivity != null && visibility != null) {
        visibility.observe(parentActivity, Observer { value -> view.visibility = value?: View.VISIBLE })
    }
}

/**
 * Sets text from string resource, if the resource id is 0 it sets empty string
 */
@BindingAdapter("textRes")
fun setTextFromResource(view: TextView, res: Int) {
    if (res == 0) {
        view.text = ""
    } else {
        view.text = view.resources.getText(res)
    }

}