package morningpages.app.niklas.morningpages

import android.support.test.InstrumentationRegistry
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.espresso.matcher.ViewMatchers.withText
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Instrumentation test, which will execute on an Android device.

 * @see [Testing documentation](http://d.android.com/tools/testing)
 */
class ExampleInstrumentedTest : SuperEspresso() {

    @Test
    @Throws(Exception::class)
    fun useAppContext() {
        assertEquals("morningpages.app.niklas.morningpages", appContext.packageName)
    }

    @Test
    fun espressoTest() {
        onView(withId(R.id.text1)).perform(click())
        onView(withId(R.id.currSingleSeconds)).check(matches(withText("0")))
    }

}
