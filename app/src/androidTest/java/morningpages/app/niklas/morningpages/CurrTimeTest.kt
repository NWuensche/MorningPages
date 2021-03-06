package morningpages.app.niklas.morningpages

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.not
import org.junit.Test


/**
 * Created by nwuensche on 12.03.17.
 */
class CurrTimeTest : SuperEspresso() {

    @Test
    fun clickOnceRight() {
        clickOne(1)
        assertThat(CurrTime.getCurrentTime(activity.activity), `is`("00:00:01"))

        onView(withId(R.id.startTimer)).check(matches(isDisplayed()))
        onView(withId(R.id.deleteLastNumber)).check(matches(isDisplayed()))
    }

    @Test
    fun clickSevenTimesRight() {
        clickOne(6)
        onView(withId(R.id.text2)).perform(click())

        assertThat(CurrTime.getCurrentTime(activity.activity), `is`("11:11:11"))

        onView(withId(R.id.startTimer)).check(matches(isDisplayed()))
        onView(withId(R.id.deleteLastNumber)).check(matches(isDisplayed()))
    }

    private fun clickOne(times: Int) {
        var often = times
        while(often > 0) {
            onView(withId(R.id.text1)).perform(click())
            often--
        }
    }

    @Test
    fun deleteRightIntegrationTest() {
        onView(withId(R.id.deleteLastNumber)).check(matches(not(isDisplayed())))
        onView(withId(R.id.startTimer)).check(matches(not(isDisplayed())))

        onView(withId(R.id.text0)).perform(click())
        onView(withId(R.id.deleteLastNumber)).check(matches(not(isDisplayed())))
        onView(withId(R.id.startTimer)).check(matches(not(isDisplayed())))

        clickOne(6)
        assertThat(CurrTime.getCurrentTime(activity.activity), `is`("11:11:11"))
        onView(withId(R.id.deleteLastNumber)).check(matches(isDisplayed()))
        onView(withId(R.id.startTimer)).check(matches(isDisplayed()))

        clickDelete(1)
        assertThat(CurrTime.getCurrentTime(activity.activity), `is`("01:11:11"))
        onView(withId(R.id.deleteLastNumber)).check(matches(isDisplayed()))
        onView(withId(R.id.startTimer)).check(matches(isDisplayed()))

        onView(withId(R.id.text2)).perform(click())
        assertThat(CurrTime.getCurrentTime(activity.activity), `is`("11:11:12"))
        onView(withId(R.id.deleteLastNumber)).check(matches(isDisplayed()))

        clickDelete(6)
        assertThat(CurrTime.getCurrentTime(activity.activity), `is`("00:00:00"))
        onView(withId(R.id.deleteLastNumber)).check(matches(not(isDisplayed())))
        onView(withId(R.id.startTimer)).check(matches(not(isDisplayed())))
    }

    private fun clickDelete(times: Int) {
        var often = times
        while(often > 0) {
            onView(withId(R.id.deleteLastNumber)).perform(click())
            often--
        }
    }

}