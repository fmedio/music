package music.chordy

import music.chordy.parser.ParserFacade
import org.junit.Test

class ChordTest {
    // TODO: remove natural 5th when explicitely altered, or when the chord gets busy?

    @Test
    fun testMajor() {
        val chord = ParserFacade().evalChord("C")
        kotlin.test.assertTrue(chord.notes.contains(60))
        kotlin.test.assertTrue(chord.notes.contains(64))
        kotlin.test.assertTrue(chord.notes.contains(67))
    }

    @Test
    fun testMinor() {
        val chord = ParserFacade().evalChord("Cm")
        kotlin.test.assertTrue(chord.notes.contains(60))
        kotlin.test.assertTrue(chord.notes.contains(63))
        kotlin.test.assertTrue(chord.notes.contains(67))
    }

    @Test
    fun testDim() {
        val chord = ParserFacade().evalChord("Cdim")
        kotlin.test.assertTrue(chord.notes.contains(60))
        kotlin.test.assertTrue(chord.notes.contains(63))
        kotlin.test.assertTrue(chord.notes.contains(66))
    }

    @Test
    fun testIntervals() {
        val chord = ParserFacade().evalChord("Cm7,7+,9+")
        kotlin.test.assertTrue(chord.notes.contains(60))
        kotlin.test.assertTrue(chord.notes.contains(63))
        kotlin.test.assertTrue(chord.notes.contains(67))
        kotlin.test.assertTrue(chord.notes.contains(70))
        kotlin.test.assertTrue(chord.notes.contains(71))
        kotlin.test.assertTrue(chord.notes.contains(75))
    }
}