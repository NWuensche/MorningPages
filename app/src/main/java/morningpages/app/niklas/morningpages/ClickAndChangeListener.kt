package morningpages.app.niklas.morningpages

import android.app.Activity
import android.app.Application
import android.content.Context
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import android.support.v4.content.ContextCompat.startActivity
import android.content.Intent
import android.view.animation.AnimationUtils


/**
 * @author nwuensche
 */
object ClickAndChangeListener {

    var monkeyFree = false

    fun onClickText(activity: Activity, pressedNum: String) {
        val timeBefore = CurrTime.getCurrentTime(activity)
        forwardText(activity, pressedNum)

        if(timeBefore == "00:00:00" && CurrTime.getCurrentTime(activity) != "00:00:00") {
            makeButtonsVisible(activity)
        }
    }

    private fun makeButtonsVisible(activity: Activity) {
        activity.deleteLastNumber.startAnimation(AnimationUtils.loadAnimation(activity.deleteLastNumber.context,R.anim.abc_fade_in))
        activity.startTimer.startAnimation(AnimationUtils.loadAnimation(activity.startTimer.context,R.anim.abc_fade_in))

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
        val timeBefore = CurrTime.getCurrentTime(activity)

        backwardText(activity)

        if(timeBefore != "00:00:00" && CurrTime.getCurrentTime(activity) == "00:00:00") {
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

        if(CurrTime.getCurrentTime(activity) != "00:00:00") {
            activity.deleteLastNumber.startAnimation(AnimationUtils.loadAnimation(activity.deleteLastNumber.context,R.anim.animation))
        }

    }

    private fun makeButtonsInvisible(activity: Activity) {
        activity.deleteLastNumber.startAnimation(AnimationUtils.loadAnimation(activity.deleteLastNumber.context,R.anim.abc_fade_out))
        activity.startTimer.startAnimation(AnimationUtils.loadAnimation(activity.startTimer.context,R.anim.abc_fade_out))

        activity.deleteLastNumber.visibility = View.INVISIBLE
        activity.startTimer.visibility = View.INVISIBLE
    }

    fun switchToWriteActivity(activity: Activity) {
        activity.startTimer.startAnimation(AnimationUtils.loadAnimation(activity.startTimer.context,R.anim.abc_fade_in))

        val intent: Intent = Intent(activity, WriteActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        intent.putExtra("time", CurrTime.getCurrentTime(activity))
        activity.startActivity(intent)
    }

    fun switchToFinishedActivity(activity: Activity) {
        val intent: Intent = Intent(activity, FinishedActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        activity.startActivity(intent)
    }

    fun switchToMonkeyFreeActivity(activity: Activity) {
        val intent: Intent = Intent(activity, MonkeyFreeActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        activity.startActivity(intent)
        monkeyFree = true
    }

}