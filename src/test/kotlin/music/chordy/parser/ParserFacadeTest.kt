package music.chordy.parser;

import org.junit.Test
import kotlin.test.assertTrue


class ParserFacadeTest {

    @Test
    fun testParse() {
        val parser = ParserFacade()
        parser.eval("append C Am")
    }
}