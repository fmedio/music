package music.chordy.parser;

import music.chordy.Note
import music.chordy.Sign
import org.junit.Assert.assertEquals
import org.junit.Test


class ParserFacadeTest {
    @Test
    fun testFoo() {
        val parser = ParserFacade();
        val chords = parser.parse("C D#m Eb7");
        assertEquals(Note.C, chords[0].fundamental);
        assertEquals(Sign.NATURAL, chords[0].sign);

        assertEquals(Note.D, chords[1].fundamental);
        assertEquals(Sign.SHARP, chords[1].sign);

        assertEquals(Note.E, chords[2].fundamental);
        assertEquals(Sign.FLAT, chords[2].sign);
    }
}