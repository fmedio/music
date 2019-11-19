package music.chordy

import music.chordy.parser.ANTLRParserParser

enum class Sign {
    NATURAL,
    FLAT,
    SHARP
}

enum class Mode {
    MAJOR,
    MINOR
}

enum class Fundamental {
    A,
    B,
    C,
    D,
    E,
    F,
    G
}


class Chord {
    val fundamental: Fundamental?
    val sign: Sign?
    val mode: Mode?

    constructor(cc: ANTLRParserParser.ChordContext) {
        fundamental = Fundamental.valueOf(cc.FUNDAMENTAL().text)
        sign = if (cc.SIGN() == null) {
            Sign.NATURAL
        } else {
            if (cc.SIGN().text.equals("#"))
                Sign.SHARP
            else
                Sign.FLAT
        }

        mode = if (cc.MINOR() == null) {
            Mode.MAJOR
        } else {
            Mode.MINOR
        }
    }
}