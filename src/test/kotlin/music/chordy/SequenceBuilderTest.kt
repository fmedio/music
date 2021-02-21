package music.chordy

import music.chordy.parser.ParserFacade
import org.junit.Assert.assertEquals
import org.junit.Test

class SequenceBuilderTest {
    @Test
    fun testBuildSequence() {
        val parser = ParserFacade()
        val chords = listOf("C", "Am", "F", "G").map(parser::evalChord).toList()
        val sequence = SequenceBuilder().sequence(chords)
        assertEquals(4, sequence.tickLength)
        assertEquals(25, sequence.tracks[0].size())
    }
}