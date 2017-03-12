package morningpages.app.niklas.morningpages

import android.app.Activity
import android.content.Context
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Created by nwuensche on 12.03.17.
 */
object CurrTime {

    fun getCurrentTime(context: Context): String {

        (context as Activity).apply {
            val tenHours = currTenHours.text.toString()
            val singleHours = currSingleHours.text.toString()

            val tenMinutes = currTenMinutes.text.toString()
            val singleMinutes = currSingleMinutes.text.toString()

            val tenSeconds = currTenSeconds.text.toString()
            val singleSeconds = currSingleSeconds.text.toString()

            return "$tenHours$singleHours:$tenMinutes$singleMinutes:$tenSeconds$singleSeconds"
        }

        // Will never be used
        return ""
    }

}