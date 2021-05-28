package music.chordy

import music.chordy.parser.ParserFacade
import javax.sound.midi.*


class SequencerState(val sequencer: Sequencer, var tempoBPM: Float = 120f)

fun main(args: Array<String>) {
    val sequencer = MidiSystem.getSequencer()
    sequencer.open()
    val parser = ParserFacade()

    var state = SequencerState(sequencer, 120f)

    while (true) {
        print("> ")
        System.out.flush()
        val line = readLine()!!
        parser.eval(line, state)
    }
}

