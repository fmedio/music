package music

import music.chordy.parser.ParserFacade
import javax.sound.midi.MidiSystem

fun main(args: Array<String>) {
    val sequencer = MidiSystem.getSequencer()
    sequencer.open()
    val parser = ParserFacade()

    while (true) {
        print("> ")
        System.out.flush()
        val line = readLine()!!
        parser.eval(line, sequencer)
    }
}

