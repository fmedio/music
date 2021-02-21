package music.chordy

import music.chordy.parser.ANTLRParserParser

class Interval {
    var offset : Int = 0

    companion object {
        val offsets = listOf(0, 2, 4, 5, 7, 9, 10);
    }

    constructor(ctx: ANTLRParserParser.Interval_specContext) {
        ctx.INTEGER()?.let { x ->
            offset += parse(x.text!!.toInt(), 0)
         } ?: 0

        offset += ctx.AUGMENTED()?.let { 1 } ?: 0
        offset -= ctx.DIMINISHED()?.let { 1 } ?: 0
    }

    private fun parse(notation: Int, offset: Int) : Int {
        if (notation < 8) {
            return offsets[notation - 1] + offset
        } else {
            return parse(notation - 7, offset + 12)
        }
    }
}