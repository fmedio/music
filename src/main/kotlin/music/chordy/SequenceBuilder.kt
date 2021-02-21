package music.chordy

import javax.sound.midi.MidiEvent
import javax.sound.midi.Sequence
import javax.sound.midi.ShortMessage

class SequenceBuilder {
    fun sequence(chords: List<Chord>): Sequence {
        val sequence = Sequence(Sequence.PPQ, 1)
        val track = sequence.createTrack()!!

        return chords.foldIndexed(sequence, { index, acc, chord ->
            chord.notes.forEach { note ->
                track.add(MidiEvent(ShortMessage(ShortMessage.NOTE_ON, 0, note, 127), index.toLong()))
                track.add(MidiEvent(ShortMessage(ShortMessage.NOTE_OFF, 0, note, 127), (index + 1).toLong()))
            }
            acc
        })
    }
}