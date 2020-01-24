package music.chordy.parser;

import music.chordy.Chord
import org.antlr.v4.runtime.ANTLRInputStream
import org.antlr.v4.runtime.BufferedTokenStream
import org.antlr.v4.runtime.tree.ParseTreeVisitor
import java.io.StringReader

class ParserFacade {
  class Visitor : ANTLRParserBaseVisitor<Int>() {
      override fun visitAppend_exp(ctx: ANTLRParserParser.Append_expContext?): Int {
          visitChildren(ctx)
          return 0
      }

      override fun visitChord(ctx: ANTLRParserParser.ChordContext?): Int {
          return 0
      }
  }

    fun eval(s: String) {
        var lexer = ANTLRParserLexer(ANTLRInputStream(StringReader(s)))
        var input = BufferedTokenStream(lexer)
        var parser = ANTLRParserParser(input)
        val exp = parser.expression()
        Visitor().visit(exp)
    }
}
