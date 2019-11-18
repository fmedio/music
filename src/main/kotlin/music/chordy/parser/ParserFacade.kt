package music.chordy.parser;

import music.chordy.Chord
import org.antlr.v4.runtime.ANTLRInputStream
import org.antlr.v4.runtime.BufferedTokenStream
import java.io.StringReader

class ParserFacade {
    fun parse(exp: String): List<Chord> {
        var lexer = ANTLRParserLexer(ANTLRInputStream(StringReader(exp)))
        var input = BufferedTokenStream(lexer)
        var parser = ANTLRParserParser(input)
        var expression = parser.expression()

        return expression.children.map { pt -> Chord(pt as ANTLRParserParser.ChordContext)};
    }
}
