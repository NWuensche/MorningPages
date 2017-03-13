package morningpages.app.niklas.morningpages

import android.app.Activity
import android.app.Application
import android.content.Context
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import android.support.v4.content.ContextCompat.startActivity
import android.content.Intent



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

    fun onClickDelete(activity: Activity) {
        backwardText(activity)

        if(CurrTime.getCurrentTime(activity).equals("00:00:00")) {
            makeButtonsInvisible(activity)
        }
    }

    private fun backwardText(activity: Activity) {
        activity.apply {
            currSingleSeconds.text = currTenSeconds.text
            currTenSeconds.text = currSingleMinutes.text

            currSingleMinutes.text = currTenMinutes.text
            currTenMinutes.text = currSingleHours.text

            currSingleHours.text = currTenHours.text
            currTenHours.text = "0"
        }
    }

    private fun makeButtonsInvisible(activity: Activity) {
        activity.deleteLastNumber.visibility = View.INVISIBLE
        activity.startTimer.visibility = View.INVISIBLE
    }

    fun switchToWriteActivity(activity: Activity) {
        val intent: Intent = Intent(activity, WriteActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        intent.putExtra("time", CurrTime.getCurrentTime(activity)) //TODO 00:90:00 -> 01:30:00
        activity.startActivity(intent)
    }

}