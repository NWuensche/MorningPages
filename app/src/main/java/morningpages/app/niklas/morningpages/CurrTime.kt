package morningpages.app.niklas.morningpages

import android.app.Activity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

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

    fun formatTimeAndCreateList(time: String): List<String> {
        return createList(formatTime(time))

    }

    fun formatTime(time: String): Time {
        val newSingleSeconds = Integer.parseInt(time[7].toString())

        val newTenSeconds = Integer.parseInt(time[6].toString()) % 6

        val tmpSingleMinutes = Integer.parseInt(time[4].toString()) + (Integer.parseInt(time[6].toString()).div(6))
        val newSingleMinutes = tmpSingleMinutes % 10

        val tmpTenMinutes = Integer.parseInt(time[3].toString()) + (tmpSingleMinutes.div(9))
        val newTenMinutes = tmpTenMinutes % 6

        val tmpSingleHours = Integer.parseInt(time[1].toString()) + (tmpTenMinutes.div(6))
        val newSingleHours = tmpSingleHours % 10

        val newTenHours = Integer.parseInt(time[0].toString()) + (tmpSingleHours.div(9))

        return Time(newTenHours*10 + newSingleHours, newTenMinutes*10 + newSingleMinutes,
                newTenSeconds*10 + newSingleSeconds)
    }

    private fun createList(time: Time): List<String> {
        val list = LinkedList<String>()
        list.add(time.toString())

        var currTime = time

        while(currTime.toString() != "00:00:00") {
            currTime = currTime.tick()
            list.add(currTime.toString())
        }

        return list
    }

}