package cz.sedlacek.weatherforecast.binding

import android.content.ContextWrapper
import android.view.View
import androidx.appcompat.app.AppCompatActivity

/**
 * View extensions, which can be used everywhere in the project
 */

/**
 * Gets parent activity, if it is AppCompatActivity, otherwise it returns null
 */
fun View.getParentActivity(): AppCompatActivity? {
    var context = this.context
    while (context is ContextWrapper) {
        if (context is AppCompatActivity) {
            return context
        }

        context = context.baseContext
    }
    return null
}