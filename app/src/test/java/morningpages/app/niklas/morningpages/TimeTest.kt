package morningpages.app.niklas.morningpages

import org.hamcrest.CoreMatchers.`is`
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).

 * @see [Testing documentation](http://d.android.com/tools/testing)
 */
class TimeTest {

    @Test
    @Throws(Exception::class)
    fun formatTimeAndCreateListRight() {
        val list = CurrTime.formatTimeAndCreateList("00:00:60")

        assertThat(list.size, `is`(61))
        assertThat(list[0], `is`("00:01:00"))
        assertThat(list[1], `is`("00:00:59"))
        assertThat(list[59], `is`("00:00:01"))
        assertThat(list[60], `is`("00:00:00"))

        val longList = CurrTime.formatTimeAndCreateList("99:99:99")

        assertThat(longList.size, `is`(362440))
        assertThat(longList[0], `is`("100:40:39"))
        assertThat(longList[362438], `is`("00:00:01"))
        assertThat(longList[362439], `is`("00:00:00"))
        //TODO Update machen, wo das schneller gemacht wird. Nicht Time objecte, sondern einfach Zahlen, da bei 99:99:99 harter Delay
    }

}