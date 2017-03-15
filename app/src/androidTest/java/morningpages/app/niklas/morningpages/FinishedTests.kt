package morningpages.app.niklas.morningpages

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.action.ViewActions.pressBack
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import org.junit.Test

/**
 * @author nwuensche
 */
class FinishedTests : SuperEspresso() {

    @Test
    fun switchWorks(){
        onView(withId(R.id.text1)).check(matches(isDisplayed()))

        switchToActivity()

        onView(withId(R.id.monkeyCage)).check(matches(isDisplayed()))
    }

    @Test
    fun backToTimer(){
        switchToActivity()

        onView(withId(R.id.monkeyCage)).check(matches(isDisplayed()))
        onView(isRoot()).perform(pressBack())
        onView(withId(R.id.text1)).check(matches(isDisplayed())) // Back at Timer
        //TODO onResume mit pressMenu und so testen, wenn geht dann auch in 5MJ


    }

    fun switchToActivity() {
        // To Write Activity
        onView(withId(R.id.text1)).perform(click())
        onView(withId(R.id.startTimer)).perform(click())

        Thread.sleep(2000) // Until Timer finished
    }


}