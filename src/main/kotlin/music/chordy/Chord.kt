package music.chordy

import music.chordy.parser.ANTLRParserParser

enum class Sign {
    NATURAL,
    FLAT,
    SHARP
}

enum class Note {
    A,
    B,
    C,
    D,
    E,
    F,
    G
}


class Chord {
    val fundamental: Note?
    val sign: Sign?

    constructor(cc: ANTLRParserParser.ChordContext) {
        fundamental = Note.valueOf(cc.NOTE().text)
        sign = if (cc.SIGN() == null) {
            Sign.NATURAL
        } else {
            if (cc.SIGN().text.equals("#"))
                Sign.SHARP
            else
                Sign.FLAT
        }
    }
}