package music.chordy

import music.chordy.parser.ParserFacade
import org.junit.Test
import kotlin.test.assertEquals

class IntervalTest {

    @Test
    fun testInterval() {
        assertEquals(10, interval("7"))
        assertEquals(4, interval("3"))
        assertEquals(12, interval("8"))
        assertEquals(14, interval("9"))
        assertEquals(13, interval("9-"))
        assertEquals(15, interval("9+"))
    }

    private fun interval(input: String) = ParserFacade().evalInterval(input).offset
}