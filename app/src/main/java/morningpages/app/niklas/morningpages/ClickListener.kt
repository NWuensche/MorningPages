package morningpages.app.niklas.morningpages

import android.app.Activity
import android.content.Context
import kotlinx.android.synthetic.main.activity_main.*

/**
 * @author nwuensche
 */
object ClickListener {


    fun onClickText(context: Context, pressedNum: String) {
        makeButtonsVisible(context)
        forwardText(context, pressedNum)
    }

    private fun makeButtonsVisible(context: Context) {
        //v.clearLastNumber.visibility = View.VISIBLE
        //v.startTimer.visibility = View.VISIBLE
    }


    private fun forwardText(context: Context, pressedNum: String) {
        //TODO Ohne activity, einfach kotlinx?
        val activity = context as Activity

        if(!activity.currTenHours.text.toString().equals("0")) {
            return
        }

        activity.apply {
            currTenHours.text = currSingleHours.text
            currSingleHours.text = currTenMinutes.text

            currTenMinutes.text = currSingleMinutes.text
            currSingleMinutes.text = currTenSeconds.text

            currTenSeconds.text = currSingleSeconds.text
            currSingleSeconds.text = pressedNum
        }
    }

}