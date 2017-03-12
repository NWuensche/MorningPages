package morningpages.app.niklas.morningpages

import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

/**
 * Created by nwuensche on 12.03.17.
 */
class StartUpTests : SuperEspresso() {

    @Test
    fun startRight() {
        assertThat(CurrTime.getCurrentTime(activity.activity), CoreMatchers.`is`("00:00:00"))
    }

}