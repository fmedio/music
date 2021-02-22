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

    val notes: MutableSet<Int> = mutableSetOf()
    private val fundamental: Int

    constructor(cc: ANTLRParserParser.ChordContext) {
        val base = scale.get(cc.NOTE().text)!!
        fundamental = cc.SIGN()?.let {
            if ("#".equals(it.text)) {
                base + 1
            } else {
                base - 1
            }
        } ?: base


        val baseChord = cc.MINOR()?.let { minorTriad } ?:
                        cc.DIM()?.let { diminishedChord } ?:
                        majorTriad
        notes.addAll(baseChord.fold(listOf(fundamental), { acc: List<Int>, i: Int -> acc.plus(i + acc.last()) }))


        class Visitor : ANTLRParserBaseVisitor<Unit>() {
            override fun visitInterval_spec(ctx: ANTLRParserParser.Interval_specContext?): Unit {
                ctx.let { x -> notes.add(Interval(x!!).offset + fundamental) }
            }
        }
        cc.accept(Visitor())
    }

}