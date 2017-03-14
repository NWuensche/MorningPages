package morningpages.app.niklas.morningpages

import android.content.Context
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.action.ViewActions.typeText
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
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
        onView(withId(R.id.show_timer)).check(matches(withText("00:00:01")))
    }

    @Test
    fun timerRight() {
        switchToWriteActivty()

        onView(withId(R.id.show_timer)).check(matches(withText("00:00:05")))
        Thread.sleep(1000)
        onView(withId(R.id.show_timer)).check(matches(withText("00:00:04")))

        testIfMorningPageIsMultiThreadWriteable()

        Thread.sleep(4000)
        onView(withId(R.id.show_timer)).check(matches(withText("Fertig")))
        //TODO Wie test, das Soft Keyboard weg ist?
    }

    /**
     * @ImplNotes sets Timer to 5 seconds
     */
    private fun switchToWriteActivty() {
        onView(withId(R.id.text5)).perform(click()) // Make StartButton Visible
        onView(withId(R.id.startTimer)).perform(click())
    }

    private fun testIfMorningPageIsMultiThreadWriteable() {
        val inputManager = appContext.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        assertThat(inputManager.isAcceptingText, `is`(true))

        onView(withId(R.id.writeText)).perform(typeText("Test"))
        onView(withId(R.id.writeText)).check(matches(withText(("Test"))))
    }

}