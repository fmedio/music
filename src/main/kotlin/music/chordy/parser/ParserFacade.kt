package music.chordy.parser

import music.chordy.Chord
import music.chordy.Interval
import music.chordy.SequenceBuilder
import music.chordy.SequencerState
import org.antlr.v4.runtime.ANTLRInputStream
import org.antlr.v4.runtime.BufferedTokenStream
import java.io.StringReader

class ParserFacade {
    fun eval(exp: String, state: SequencerState) {
        val exp = parser(exp).expression()

        class Visitor : ChordyBaseVisitor<Unit>() {
            val chords = mutableListOf<Chord>()

            override fun visitStop_exp(ctx: ChordyParser.Stop_expContext?) {
                state.sequencer.stop()
            }

            override fun visitChord(ctx: ChordyParser.ChordContext?) {
                ctx?.let { cc -> chords.add(Chord(cc)) }
            }

            override fun visitPlay_exp(ctx: ChordyParser.Play_expContext?) {
                ctx?.chord_list()?.accept(this)
                val sequence = SequenceBuilder().sequence(chords)
                state.sequencer.stop()
                state.sequencer.sequence = sequence
                state.sequencer.tempoInBPM = state.tempoBPM
                state.sequencer.start()
            }

            override fun visitLoop_exp(ctx: ChordyParser.Loop_expContext?) {
                ctx?.chord_list()?.accept(this)
                val sequence = SequenceBuilder().sequence(chords)
                state.sequencer.stop()
                state.sequencer.loopStartPoint = 0
                state.sequencer.tempoInBPM = state.tempoBPM
                state.sequencer.sequence = sequence
                state.sequencer.loopEndPoint = sequence.tickLength
                state.sequencer.loopCount = Integer.MAX_VALUE
                state.sequencer.start()
            }

            override fun visitTempo_exp(ctx: ChordyParser.Tempo_expContext?) {
                ctx.let {
                    state.tempoBPM = it!!.INTEGER().text.toFloat()
                }
            }
        }

        exp.accept(Visitor())
    }

    private fun parser(s: String): ChordyParser {
        var lexer = ChordyLexer(ANTLRInputStream(StringReader(s)))
        var input = BufferedTokenStream(lexer)
        return ChordyParser(input)
    }

    fun evalChord(s: String): Chord {
        val chordContext = parser(s).chord()
        return Chord(chordContext)
    }

    fun evalInterval(s: String): Interval {
        val ctx = parser(s).interval_spec()
        return Interval(ctx)
    }
}
