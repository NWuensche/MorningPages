package morningpages.app.niklas.morningpages

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withId
import org.hamcrest.CoreMatchers
import org.hamcrest.CoreMatchers.not
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

/**
 * Created by nwuensche on 12.03.17.
 */
class StartUpTests : SuperEspresso() {

    @Test
    fun startRight() {
        assertThat(CurrTime.getCurrentTime(activity.activity), CoreMatchers.`is`("00:00:00"))

        onView(withId(R.id.startTimer)).check(matches(not(isDisplayed())))
        onView(withId(R.id.deleteLastNumber)).check(matches(not(isDisplayed())))
    }

}