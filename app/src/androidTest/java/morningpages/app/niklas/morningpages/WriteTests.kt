package morningpages.app.niklas.morningpages

import android.content.Context
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.view.inputmethod.InputMethodManager
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test


/**
 * @author nwuensche
 */
class WriteTests : SuperEspresso() {

    @Test
    fun startButtonOnTimerWorks() {
        //TODO Nutze das, um StoppUhr zu testen:     SystemClock.sleep(500);
        val inputManager = appContext.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager

        onView(withId(R.id.text1)).check(matches(isDisplayed()))
        assertThat(inputManager.isAcceptingText, `is`(false))

        onView(withId(R.id.text1)).perform(click()) // Make StartButton Visible
        onView(withId(R.id.startTimer)).perform(click())

        assertThat(inputManager.isAcceptingText, `is`(true))

        onView(withId(R.id.writeText)).check(matches(isDisplayed()))
    }

}