package morningpages.app.niklas.morningpages

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.EspressoKey
import android.support.test.espresso.action.ViewActions.*
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import org.junit.Test

/**
 * @author nwuensche
 */
class MonkeyFreeTests : SuperEspresso() {

    @Test
    fun switchWorks(){
        onView(withId(R.id.text1)).check(matches(isDisplayed()))

        switchToActivity()

        onView(withId(R.id.monkeyFree)).check(matches(isDisplayed()))
    }

    fun switchToActivity() {
        // To Write Activity
        onView(withId(R.id.text2)).perform(click())
        onView(withId(R.id.startTimer)).perform(click())

        //onView(isRoot()).perform(pressKey(EspressoKey.Builder().withKeyCode()))
        onView(isRoot()).perform(pressImeActionButton())

        Thread.sleep(2000) // Until Timer finished
    }

}