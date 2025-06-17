package src.algos;

import java.util.ArrayList;
import java.util.List;

public class MethodRecursiveDescent {
    public static void main(String[] args) {
        String expressionText = "-22 + 2 * ( 2 + 2 ) * 4";
        List<Lexeme> lexemes = new LexemeAnalyzer().lexemeAnalyze(expressionText);
        LexemeBuffer lexemeBuffer = new LexemeBuffer(lexemes);
        int result = new LexemeAnalyzer().expr(lexemeBuffer);
        System.out.println(result);

    }
}


enum LexemeType {
    NUMBER, PLUS, MINUS, MULTIPLY, DIVIDE, LEFT_BRACKET, RIGHT_BRACKET, EOF
    }

class LexemeBuffer {
    private int pos;

    public List<Lexeme> lexemes;

    public LexemeBuffer(List<Lexeme> lexemes) {
        this.lexemes = lexemes;
    }

    public Lexeme next() {
        return lexemes.get(pos++);
    }

    public void back() {
        pos--;
    }

    public int getPos() {
        return pos;
    }
}

class Lexeme {
    LexemeType type;

    String value;

    Lexeme(LexemeType type, String value) {
        this.type = type;
        this.value = value;
    }

    public Lexeme(LexemeType type, Character character) {
        this.type = type;
        this.value = character.toString();
    }

    @Override
    public String toString() {
        return "Lexeme{" + "type=" + type + ", value='" + value + '\'' + '}';
    }

    public LexemeType getType() {
        return type;
    }

    public String getValue() {
        return value;
    }
}
class LexemeAnalyzer {

    public List<Lexeme> lexemeAnalyze(String expression) {
        ArrayList<Lexeme> lexemes = new ArrayList<>();
        int pos = 0;
        while (pos < expression.length()) {
            char currentChar = expression.charAt(pos);
            switch (currentChar) {
                case '+':
                    lexemes.add(new Lexeme(LexemeType.PLUS, currentChar));
                    pos++;
                    continue;
                case '-':
                    lexemes.add(new Lexeme(LexemeType.MINUS, currentChar));
                    pos++;
                    continue;
                case '*':
                    lexemes.add(new Lexeme(LexemeType.MULTIPLY, currentChar));
                    pos++;
                    continue;
                case '/':
                    lexemes.add(new Lexeme(LexemeType.DIVIDE, currentChar));
                    pos++;
                    continue;
                case '(':
                    lexemes.add(new Lexeme(LexemeType.LEFT_BRACKET, currentChar));
                    pos++;
                    continue;
                case ')':
                    lexemes.add(new Lexeme(LexemeType.RIGHT_BRACKET, currentChar));
                    pos++;
                    continue;
                default:
                    if (currentChar <= '9' && currentChar >= '0') {
                        StringBuilder sb = new StringBuilder();
                        do {
                            sb.append(currentChar);
                            pos++;
                            if (pos >= expression.length()) {
                                break;
                            } else {
                                currentChar = expression.charAt(pos);
                            }
                        } while (currentChar <= '9' && currentChar >= '0');
                        lexemes.add(new Lexeme(LexemeType.NUMBER,sb.toString()));

                    } else {
                        if (currentChar != ' ') {
                            throw new IllegalArgumentException("Unexpected character: " + currentChar);
                        }
                        pos++;
                    }
            }
        }
        lexemes.add(new Lexeme(LexemeType.EOF, ""));
        return lexemes;
    }


    /*------------------------------------------------------------------
     * PARSER RULES
     *------------------------------------------------------------------
     expr : plusminus* EOF ;

     plusminus: multdiv ( ( '+' | '-' ) multdiv )* ;

     multdiv : factor ( ( '*' | '/' ) factor )* ;

     factor : NUMBER | '(' expr ')' ;
    */

    public int expr(LexemeBuffer lexemes) {
        Lexeme lexeme = lexemes.next();
        if (lexeme.type == LexemeType.EOF) {
            return 0;
        } else {
            lexemes.back();
            return plusminus(lexemes);
        }
    }

    public int plusminus(LexemeBuffer lexemes) {
        int value = multdiv(lexemes);
        while (true) {
            Lexeme lexeme = lexemes.next();
            switch (lexeme.type) {
                case PLUS:
                    value += multdiv(lexemes);
                    break;
                case MINUS:
                    value -= multdiv(lexemes);
                    break;
                case EOF:
                case RIGHT_BRACKET:
                    lexemes.back();
                    return value;
                default:
                    throw new RuntimeException("Unexpected token: " + lexeme.value
                            + " at position: " + lexemes.getPos());
            }
        }
    }

    public int multdiv(LexemeBuffer lexemes) {
        int value = factor(lexemes);
        while (true) {
            Lexeme lexeme = lexemes.next();
            switch (lexeme.type) {
                case MULTIPLY:
                    value *= factor(lexemes);
                    break;
                case DIVIDE:
                    value /= factor(lexemes);
                    break;
                case EOF:
                case RIGHT_BRACKET:
                case PLUS:
                case MINUS:
                    lexemes.back();
                    return value;
                default:
                    throw new RuntimeException("Unexpected token: " + lexeme.value
                            + " at position: " + lexemes.getPos());
            }
        }
    }
    public int factor(LexemeBuffer lexemes) {
        Lexeme lexeme = lexemes.next();
        switch (lexeme.type) {
            case MINUS:
                return -factor(lexemes);
            case NUMBER:
                return Integer.parseInt(lexeme.value);
            case LEFT_BRACKET:
                int value = expr(lexemes);
                lexeme = lexemes.next();
                if (lexeme.type != LexemeType.RIGHT_BRACKET) {
                    throw new RuntimeException("Unexpected token: " + lexeme.value
                            + " at position: " + lexemes.getPos());
                }
                return value;
            default:
                throw new RuntimeException("Unexpected token: " + lexeme.value
                        + " at position: " + lexemes.getPos());
        }
    }

}


