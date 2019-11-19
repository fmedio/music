package music.chordy.parser;

import music.chordy.Fundamental
import music.chordy.Mode
import music.chordy.Sign
import org.junit.Assert.assertEquals
import org.junit.Test


class ParserFacadeTest {
    @Test
    fun testFoo() {
        val parser = ParserFacade();
        val chords = parser.parse("C D#m Eb7")

        assertEquals(Fundamental.C, chords[0].fundamental)
        assertEquals(Sign.NATURAL, chords[0].sign)
        assertEquals(Mode.MAJOR, chords[0].mode)

        assertEquals(Fundamental.D, chords[1].fundamental)
        assertEquals(Sign.SHARP, chords[1].sign)
        assertEquals(Mode.MINOR, chords[1].mode)

        assertEquals(Fundamental.E, chords[2].fundamental)
        assertEquals(Sign.FLAT, chords[2].sign)
        assertEquals(Mode.MAJOR, chords[2].mode)
    }
}