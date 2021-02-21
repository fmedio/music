package music.chordy.parser;

import org.junit.Test
import kotlin.test.assertTrue


class ParserFacadeTest {
    @Test
    fun testBasic() {
        var chord = ParserFacade().evalChord("C")
        assertTrue(chord.notes.contains(60))
        assertTrue(chord.notes.contains(64))
        assertTrue(chord.notes.contains(67))

        chord = ParserFacade().evalChord("Cm")
        assertTrue(chord.notes.contains(60))
        assertTrue(chord.notes.contains(63))
        assertTrue(chord.notes.contains(67))

        //        assertEquals(Note.C, chords[0].fundamental)
//        assertEquals(Sign.NATURAL, chords[0].sign)
//
//        assertEquals(Note.D, chords[1].fundamental)
//        assertEquals(Sign.SHARP, chords[1].sign)
//
//        assertEquals(Note.E, chords[2].fundamental)
//        assertEquals(Sign.FLAT, chords[2].sign);
    }

    @Test
    fun testParse() {
        val parser = ParserFacade()
        parser.eval("append C Am")
    }
}