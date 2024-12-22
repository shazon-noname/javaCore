package algos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MethodRecursiveDescent {
    /*------------------------------------------------------------------
     * PARSER RULES
     *------------------------------------------------------------------*/

//    expr : plusminus* EOF ;
//
//    plusminus: multdiv ( ( '+' | '-' ) multdiv )* ;
//
//    multdiv : factor ( ( '*' | '/' ) factor )* ;
//
//    factor : NUMBER | '(' expr ')' ;

    public static void main(String[] args) {
        String expressionText = "22 + 3 - 2 * (2 * 5 + 2) * 4";
        List<Lexeme> lexemes = lexemeAnalyze(expressionText);
    }

    public enum LexemeType {
        NUMBER, LEFT_BRACKET, RIGHT_BRACKET, PLUS, MINUS, MULTIPLY, DIVIDE, EOF;
    }

    public static class Lexeme {
        LexemeType type;
        String value;

        Lexeme(LexemeType type, String value) {
            this.type = type;
            this.value = value;
        }


        @Override
        public String toString() {
            return "Lexeme{" +
                    "type=" + type +
                    ", value='" + value + '\'' +
                    '}';
        }
    }

    public static class BufferLexeme {
        private int pos;
        List<Lexeme> lexeme;

        public BufferLexeme(List<Lexeme> lexeme) {
            this.lexeme = lexeme;
        }

        public Lexeme next() {
            return lexeme.get(pos++);
        }

        public void back() {
            pos--;
        }

        public int getPos() {
            return pos;
        }
    }

    public static List<Lexeme> lexemeAnalyze(String expression) {
        List<Lexeme> lexemeList = new ArrayList<Lexeme>();
        int pos = 0;
        while (pos < expression.length()) {
            char ch = expression.charAt(pos);
            switch (ch) {
                case '(':
                    lexemeList.add(new Lexeme(LexemeType.LEFT_BRACKET, expression.substring(pos, pos + 1)));
                    pos++;
                    continue;
                case ')':
                    lexemeList.add(new Lexeme(LexemeType.RIGHT_BRACKET, expression.substring(pos, pos + 1)));
                    pos++;
                    continue;
                case '+':
                    lexemeList.add(new Lexeme(LexemeType.PLUS, expression.substring(pos, pos + 1)));
                    pos++;
                    continue;
                case '-':
                    lexemeList.add(new Lexeme(LexemeType.MINUS, expression.substring(pos, pos + 1)));
                    pos++;
                    continue;
                case '*':
                    lexemeList.add(new Lexeme(LexemeType.MULTIPLY, expression.substring(pos, pos + 1)));
                    pos++;
                    continue;
                case '/':
                    lexemeList.add(new Lexeme(LexemeType.DIVIDE, expression.substring(pos, pos + 1)));
                    pos++;
                    continue;
                default:
                    if (Character.isDigit(ch)) {
                        StringBuilder stringBuilder = new StringBuilder();
                        do {
                            stringBuilder.append(ch);
                            pos++;
                            if (pos >= expression.length()) {
                                break;
                            }
                            ch = expression.charAt(pos);
                        } while (Character.isDigit(expression.charAt(pos)));
                        lexemeList.add(new Lexeme(LexemeType.NUMBER, stringBuilder.toString()));
                    } else {
                        if (expression.charAt(pos) != ' ') {
                            throw new RuntimeException("Unexpected character: " + expression.charAt(pos));
                        }
                        pos++;
                    }
            }
        }
        lexemeList.add(new Lexeme(LexemeType.EOF, ""));
        return lexemeList;
    }
}
