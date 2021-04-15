import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CorrectBracketSequencePredicateTest {

    @Test
    void lineLength() {
        assertThrows(StringIndexOutOfBoundsException.class,
                () -> CorrectBracketSequencePredicate.test(" структура данных, представляющая из себя упорядоченный набор элементов, в которой добавление новых элементов и удаление существующих производится с одного конца, называемого вершиной стека. "));

    }

    @Test
    void testCorrectInput() {
        assertTrue(CorrectBracketSequencePredicate.test("(([{}]))"));
    }

    @Test
    void testIncorrectInput() {
        assertFalse(CorrectBracketSequencePredicate.test("((}}{]()"));
    }

    @Test
    void testIncorrectSimbol() {
        assertThrows(IllegalArgumentException.class,
                () -> CorrectBracketSequencePredicate.test("H)"));
    }


}