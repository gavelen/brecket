import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Stack;

public class CorrectBracketSequencePredicate {
    private final static char ROUND_BRACKET_OPEN = '(';
    private final static char ROUND_BRACKET_CLOSE = ')';
    private final static char SQUARE_BRACKET_OPEN = '[';
    private final static char SQUARE_BRACKET_CLOSE = ']';
    private final static char BRACE_OPEN = '{';
    private final static char BRACE_CLOSE = '}';


    private CorrectBracketSequencePredicate(){
    }

    //метод тест
    public static boolean test (@Nullable String sequence) {
        Stack<Short> stackBrackets = new Stack<Short>();
        ArrayList<Character> brackets = new ArrayList<Character>();
        brackets.add(ROUND_BRACKET_OPEN);
        brackets.add(ROUND_BRACKET_CLOSE);
        brackets.add(SQUARE_BRACKET_OPEN);
        brackets.add(SQUARE_BRACKET_CLOSE);
        brackets.add(BRACE_OPEN);
        brackets.add(BRACE_CLOSE);

        ArrayList<Character> openBrackets = new ArrayList<Character>();
        openBrackets.add(ROUND_BRACKET_OPEN);
        openBrackets.add(SQUARE_BRACKET_OPEN);
        openBrackets.add(BRACE_OPEN);


        //проверка длины строки
        if (sequence.length() > 100) {
            throw new StringIndexOutOfBoundsException("Line's length is more then 100");
        }

        for (char simbol: sequence.toCharArray()) {
            //проверка на прочие символы
            if (!brackets.contains(simbol)) {
                throw new IllegalArgumentException("Not a bracket");
            }

            if (openBrackets.contains(simbol)) {
                stackBrackets.push((short) simbol);
            }
            else {
                if (stackBrackets.empty()){
                    return false;
                }
                Short lastOpenBracket = stackBrackets.pop();
                if (lastOpenBracket == ROUND_BRACKET_OPEN && simbol == ROUND_BRACKET_CLOSE)
                    continue;
                else if(lastOpenBracket == SQUARE_BRACKET_OPEN && simbol == SQUARE_BRACKET_CLOSE)
                    continue;
                else if (lastOpenBracket == BRACE_OPEN && simbol == BRACE_CLOSE)
                    continue;
                else
                    return false;
            }

        }

        return stackBrackets.empty();

    }

    //метод последней строки

    //метод статистики







}
