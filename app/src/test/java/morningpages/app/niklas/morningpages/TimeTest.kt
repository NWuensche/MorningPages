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
        val longList = CurrTime.formatTimeAndCreateList("99:99:99")

        assertThat(longList.size, `is`(362440))
        assertThat(longList[0], `is`("100:40:39"))
        assertThat(longList[362438], `is`("00:00:01"))
        assertThat(longList[362439], `is`("00:00:00"))
        //TODO Ist dieser Ansatz zu langsam fürs Handy? Probiere mit 99:99:99, wie lange übergang zu anderer Acitivty bruacht
    }

}