package morningpages.app.niklas.morningpages

import android.app.Activity
import android.app.Application
import android.content.Context
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

/**
 * @author nwuensche
 */
object ClickListener {


    fun onClickText(activity: Activity, pressedNum: String) {
        makeButtonsVisible(activity)
        forwardText(activity, pressedNum)
    }

    private fun makeButtonsVisible(activity: Activity) {
        activity.deleteLastNumber.visibility = View.VISIBLE
        activity.startTimer.visibility = View.VISIBLE
    }


    private fun forwardText(activity: Activity, pressedNum: String) {
        activity.apply {
            if(!currTenHours.text.toString().equals("0")) {
                return
            }

            currTenHours.text = currSingleHours.text
            currSingleHours.text = currTenMinutes.text

            currTenMinutes.text = currSingleMinutes.text
            currSingleMinutes.text = currTenSeconds.text

            currTenSeconds.text = currSingleSeconds.text
            currSingleSeconds.text = pressedNum
        }
    }

}