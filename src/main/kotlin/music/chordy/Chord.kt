package music.chordy

import music.chordy.parser.ANTLRParserBaseVisitor
import music.chordy.parser.ANTLRParserParser

class Chord  {
    companion object {
        val scale = listOf(
            Pair("C", 60),
            Pair("D", 62),
            Pair("E", 64),
            Pair("F", 65),
            Pair("G", 67),
            Pair("A", 69),
            Pair("B", 71)
        ).map { it.first to it.second }.toMap()

        val majorTriad = listOf(0, 4, 3)
        val minorTriad = listOf(0, 3, 4)
        val diminishedChord = listOf(0, 3, 3, 3)
    }

    var notes = mutableSetOf<Int>()
    private val fundamental: Int

    fun parseNote(note: String, modifier: String?): Int {
        val base = scale[note]!!

        return modifier?.let { x ->
            if ("#".equals(x)) {
                return base + 1
            } else {
                return base - 1
            }
        } ?: base
    }

    constructor(cc: ANTLRParserParser.ChordContext) {
        fundamental = parseNote(cc.NOTE().text!!, cc.SIGN()?.text)

        val baseChord = cc.MINOR()?.let { minorTriad } ?: cc.DIM()?.let { diminishedChord } ?: majorTriad

        notes.addAll(baseChord.fold(listOf(fundamental), { acc: List<Int>, i: Int -> acc.plus(i + acc.last()) }))

        cc.bass_spec() ?: notes.add(fundamental - 12)

        class Visitor : ANTLRParserBaseVisitor<Unit>() {
            override fun visitInterval_spec(ctx: ANTLRParserParser.Interval_specContext?): Unit {
                ctx.let { notes.add(Interval(it!!).offset + fundamental) }
            }

            override fun visitBass_spec(ctx: ANTLRParserParser.Bass_specContext?) {
                ctx.let {
                    val bass = parseNote(it!!.NOTE().text!!, it.SIGN()?.text)
                    val octave = it.INTEGER()?.text?.toInt() ?: 3
                    val bassNote = bass - ((4 - octave) * 12)
                    notes.add(bassNote)
                }
            }
        }
        cc.accept(Visitor())
    }

}