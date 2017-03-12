package morningpages.app.niklas.morningpages

import android.app.Activity
import android.content.Context
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Created by nwuensche on 12.03.17.
 */
object CurrTime {

    fun getCurrentTime(activity: Activity): String {
        val tenHours = activity.currTenHours.text.toString()
        val singleHours = activity.currSingleHours.text.toString()

        val tenMinutes = activity.currTenMinutes.text.toString()
        val singleMinutes = activity.currSingleMinutes.text.toString()

        val tenSeconds = activity.currTenSeconds.text.toString()
        val singleSeconds = activity.currSingleSeconds.text.toString()

        return "$tenHours$singleHours:$tenMinutes$singleMinutes:$tenSeconds$singleSeconds"
    }

}