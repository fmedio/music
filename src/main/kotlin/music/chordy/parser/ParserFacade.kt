package music.chordy.parser

import music.chordy.Chord
import music.chordy.Interval
import music.chordy.SequenceBuilder
import org.antlr.v4.runtime.ANTLRInputStream
import org.antlr.v4.runtime.BufferedTokenStream
import java.io.StringReader
import javax.sound.midi.Sequencer

class ParserFacade {
    fun eval(exp: String, sequencer: Sequencer) {
        val exp = parser(exp).expression()

        class Visitor : ANTLRParserBaseVisitor<Unit>() {
            val chords = mutableListOf<Chord>()

            override fun visitStop_exp(ctx: ANTLRParserParser.Stop_expContext?) {
                sequencer.stop()
            }

            override fun visitChord(ctx: ANTLRParserParser.ChordContext?) {
                ctx?.let { cc -> chords.add(Chord(cc)) }
            }

            override fun visitPlay_exp(ctx: ANTLRParserParser.Play_expContext?) {
                ctx?.chord_list()?.accept(this)
                val sequence = SequenceBuilder().sequence(chords)
                sequencer.stop()
                sequencer.sequence = sequence
                sequencer.tempoInBPM = 50f
                sequencer.start()
            }
        }

        exp.accept(Visitor())
    }

    private fun parser(s: String): ANTLRParserParser {
        var lexer = ANTLRParserLexer(ANTLRInputStream(StringReader(s)))
        var input = BufferedTokenStream(lexer)
        return ANTLRParserParser(input)
    }

    fun evalChord(s: String) : Chord {
        val chordContext = parser(s).chord()
        return Chord(chordContext)
    }

    fun evalInterval(s: String) : Interval {
        val ctx = parser(s).interval_spec()
        return Interval(ctx)
    }
}
