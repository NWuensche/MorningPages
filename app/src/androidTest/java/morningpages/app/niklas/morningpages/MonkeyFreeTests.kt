package morningpages.app.niklas.morningpages

import android.support.test.InstrumentationRegistry
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.*
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.uiautomator.UiDevice
import junit.framework.Assert.fail
import org.junit.Test


/**
 * @author nwuensche
 */
class MonkeyFreeTests : SuperEspresso() {

    @Test
    fun switchWorks(){
        onView(withId(R.id.text1)).check(matches(isDisplayed()))

        switchToActivity()

        Thread.sleep(1000)
        onView(withId(R.id.monkeyFree)).check(matches(isDisplayed()))
    }

    @Test
    fun doesNotSwitchToCageWhilePaused(){
        onView(withId(R.id.text5)).perform(click())
        onView(withId(R.id.startTimer)).perform(click())

        Thread.sleep(1000)
        val mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())
        mDevice.pressRecentApps()

        Thread.sleep(5000)
        try{
            onView(withId(R.id.monkeyFree)).check(matches(isDisplayed()))
            fail()
        }
        catch(e: Exception){
            mDevice.pressRecentApps()
        }
    }

    @Test
    fun freeAndWriteAgainWorks(){
        switchToActivity()
        Thread.sleep(500)
        onView(isRoot()).perform(pressBack())

        onView(withId(R.id.text2)).perform(click())
        onView(withId(R.id.startTimer)).perform(click())

        onView(withId(R.id.writeText)).check(matches(withText("")))

        Thread.sleep(2000)

        onView(withId(R.id.monkeyCage)).check(matches(isDisplayed()))
    }

    fun switchToActivity() {
        // To Write Activity
        onView(withId(R.id.text9)).perform(click())
        onView(withId(R.id.startTimer)).perform(click())

        Thread.sleep(1000)
        onView(withId(R.id.writeText)).perform(typeText("Hello"))

        val mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())
        mDevice.pressRecentApps()
        Thread.sleep(500)
        mDevice.pressRecentApps()
    }

}